package com.co.test.wstest.util;

import java.util.Date;
import java.util.UUID;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import org.apache.camel.Exchange;
import org.apache.cxf.message.MessageContentsList;

import com.co.test.wsdl.ActualizarRequest;
import com.co.test.wsdl.ActualizarResponse;
import com.co.test.wsdl.ConsultarRequest;
import com.co.test.wsdl.ConsultarResponse;
import com.co.test.wsdl.CrearRequest;
import com.co.test.wsdl.CrearResponse;
import com.co.test.wsdl.Excepcion;
import com.co.test.wstest.util.JsonFault.ErrorDetalle;

/**
 * Clase fachada para la invocacion de los metodos dentro del contexto camel
 *
 * <li>Historial de Versiones :</li>
 * <ul>
 * <li>Autor : Camilo</li>
 * <li>Version : 1.0.0</li>
 * <li>Fecha : 26/05/2022</li>
 * <li>Descripción : Creación de la clase</li>
 * </ul>
 */
public class RouteFacade {

	private static final Integer CONS_CANTIDAD_ERRORES = 1;
  private static final int CONS_LARGO_UUID = 24;
	private static final String CONS_NOMBRE_SERVICIO = "wstest";
	private static final String CONS_REQUEST_ENTRADA= "requestEntrada";
	private static final String CONS_CODIGO_ERROR = "codigoError";
	private static final String CONS_TIPO_REQUEST = "tipoRequest";

	/**
	 * Constructor de la clase
	 *
	 * <li>Historial de Versiones :</li>
	 * <ul>
	 * <li>Autor : Camilo</li>
	 * <li>Version : 1.0.0</li>
	 * <li>Fecha : 26/05/2022</li>
	 * <li>Descripción : Creación del metodo</li>
	 * </ul>
	 */
	public RouteFacade() {
	}

	/**
	 * Se encarga de retornar el mensaje de excepción de la ruta inicio el
	 * contexto camel
	 * <li>Historial de Versiones :</li>
	 * <ul>
	 * <li>Autor : Camilo</li>
	 * <li>Version : 1.0.0</li>
	 * <li>Fecha : 26/05/2022</li>
	 * <li>Descripción : Creación del metodo</li>
	 * </ul>
	 *
	 * @param exchange
	 *            Mensaje exchange
	 */
	
	public  void responderCrear (Exchange exchange) {
		
		  String canal = exchange.getProperty("canalLlamada").toString();
		  String userI= exchange.getProperty("userId").toString();
		    
		Integer canal1 = Integer.parseInt(canal);
		Integer userI1= Integer.parseInt(userI);
		
		CrearResponse crearResponse = new CrearResponse();
		if (canal1>= userI1){
			
			crearResponse.setCodRespuesta("200");
			crearResponse.setDescripcion("un usuario nuevo");
			crearResponse.setFormato("userId mayor a canal de llamada");}
		else{
			crearResponse.setCodRespuesta("200");
			crearResponse.setDescripcion("un usuario nuevo");
			crearResponse.setFormato("canal de llamada mayor a userid");
		}
	
			exchange.getIn().setBody(crearResponse);
			
		}
	
	public  void responderConsultar (Exchange exchange) {
		
		  Integer salario = (Integer) exchange.getProperty("salario");
		  
		  int desPension = (int) (salario *0.04);
		  int dessalud = (int) (salario *0.01);
		  int desSena = (int) (salario *0.035);
		  int totalDes = desPension+dessalud+desSena;
		
		ConsultarResponse consultarResponse = new ConsultarResponse();
		if (salario< 2000000){
			
			consultarResponse.setDescripcion("Salario inválido");
			consultarResponse.setSalario(salario);
			}
		else{
			consultarResponse.setSalario(salario-totalDes);
			consultarResponse.setDescripcion("Salario pagado");
		}
	
			exchange.getIn().setBody(consultarResponse);
			
		}
	public void crearJMSCorrelationId24(Exchange exchange) {
		exchange.getIn().setHeader("JMSCorrelationID", generarCorrelationId(CONS_LARGO_UUID));
	}

    /**
   * Genera un UUID
   * <li>Historial de Versiones :</li>
   * <ul>
   * <li>Autor : Camilo</li>
   * <li>Version : 1.0.0</li>
   * <li>Fecha : 26/05/2022</li>
   * <li>Descripción : Creación del metodo</li>
   * </ul>
   *
   * @param exchange
   *            Mensaje exchange
   */
   public String generarCorrelationId(int largo) {
 		UUID uuid24 = UUID.randomUUID();
 		return uuid24.toString().replaceAll("-", "").substring(0, largo);
 	}

	/**
	 * Genera el mensaje de error para la cola AMQ Fault.
	 *
	 * <li>Historial de Versiones :</li>
	 * <ul>
	 * <li>Autor : Camilo</li>
	 * <li>Version : 1.0.0</li>
	 * <li>Fecha : 26/05/2022</li>
	 * <li>Descripción : Creación del metodo</li>
	 * </ul>
	 */
	public void excepcionAmq(Exchange exchange) {
    JsonFault json = new JsonFault();
		String identificador = generarCorrelationId(CONS_LARGO_UUID);
		Object objRequest = exchange.getProperty(CONS_REQUEST_ENTRADA, MessageContentsList.class).get(0);
		Integer codigoError = exchange.getProperty(CONS_CODIGO_ERROR, Integer.class);

		json.setRequest(objRequest);
		json.setOperacion(exchange.getProperty(CONS_TIPO_REQUEST) != null ? exchange.getProperty(CONS_TIPO_REQUEST, String.class).replace("Request", "") : "No especificado");
		json.setNombre(CONS_NOMBRE_SERVICIO);
		json.setIdentificador(identificador);
		json.setFecha((new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")).format(new Date()));

		//TODO esta implementación puede cambiar de acuerdo a la logica del servicio.
		//La logica prensentada, es generica.
		ErrorDetalle detalle = new ErrorDetalle();
		detalle.setCodigo(codigoError);
		detalle.setMensaje(RouteExcepcion.generarMensajeError(codigoError));
		detalle.setDetalle(exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class).getMessage());
		json.setError(detalle);
		// fin TODO

		try {
			Field canalLlamada = objRequest.getClass().getDeclaredField("canalLlamada");
			canalLlamada.setAccessible(Boolean.TRUE);
			json.setCanalLlamada(canalLlamada.get(objRequest).toString());
		} catch (Exception e) {
			json.setCanalLlamada("");
		}

		exchange.setProperty("identificadorError", identificador);
		exchange.getIn().setBody(json);
	}

	/**
	 * Genera el mensaje de error para la respuesta del servicio.
	 *
	 * <li>Historial de Versiones :</li>
	 * <ul>
	 * <li>Autor : Camilo</li>
	 * <li>Version : 1.0.0</li>
	 * <li>Fecha : 26/05/2022</li>
	 * <li>Descripción : Creación del meotodo</li>
	 * </ul>
	 */
	public void excepcionCrear(Exchange exchange) {

    String request = exchange.getProperty(CONS_TIPO_REQUEST, String.class);
		Excepcion excepcion = RouteExcepcion.crear(exchange, request, CONS_CANTIDAD_ERRORES);

		if (CrearRequest.class.getSimpleName().equalsIgnoreCase(request)) {
			CrearResponse response = new CrearResponse();
			response.setError(excepcion);
			exchange.getOut().setBody(response);
		} else if (ActualizarRequest.class.getSimpleName().equalsIgnoreCase(request)) {
			ActualizarResponse response = new ActualizarResponse();
			response.setError(excepcion);
			exchange.getOut().setBody(response);
		} else if (ConsultarRequest.class.getSimpleName().equalsIgnoreCase(request)) {
			ConsultarResponse response = new ConsultarResponse();
			response.setError(excepcion);
			exchange.getOut().setBody(response);
		}

	}
}
