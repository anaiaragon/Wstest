package com.co.test.wstest.util;

import org.apache.camel.Exchange;

import com.co.test.wsdl.DetalleError;
import com.co.test.wsdl.Errores;
import com.co.test.wsdl.Excepcion;

/**
 * Clase centralizadora de los mensajes de error de respuesta
 *
 * <li>Historial de Versiones :</li>
 * <ul>
 * <li>Autor : Camilo</li>
 * <li>Version : 1.0.0</li>
 * <li>Fecha : 26/05/2022</li>
 * <li>Descripción : Clase Encargada de generar los mensajes de excepcion dentro
 * del contexto camel</li>
 * </ul>
 */
public class RouteExcepcion {

	private static final String PROP_CODIGO_ERROR_500 = "Error interno del servidor";
	private static final String PROP_CODIGO_ERROR_502 = "Tiempo de respuesta excedido AMQ";
	private static final String CONS_CODIGO_ERROR = "codigoError";
	private static final String PROP_ORIGEN_WS = "wstest_";

	/**
	 * Se encarga de generar el objeto de excepción segun parametros indicados.
	 * <li>Historial de Versiones :</li>
	 * <ul>
	 * <li>Autor : Camilo</li>
	 * <li>Version : 1.0.0</li>
	 * <li>Fecha : 26/05/2022</li>
	 * <li>Descripción : Creación del metodo</li>
	 * </ul>
	 * <ul>
	 *
   * @param exchange Mensaje exchange
	 * @param origen Indica el metodo donde se origino la excepcion
	 * @param cantidadErrores Indica la cantidad de errores generados por la excepcion
	 * @param codigo Codigo del error
	 * @return objeto excepcion
	 */
	public static final Excepcion crear(Exchange exchange, String origen, Integer cantidadErrores) {

		DetalleError detalle = new DetalleError();
		Integer codigo = exchange.getProperty(CONS_CODIGO_ERROR, Integer.class);

		detalle.setDescripcion(generarMensajeError(codigo));

		Excepcion excepcion = new Excepcion();
		excepcion.setIdentificador(exchange.getProperty("identificadorError", String.class));
		excepcion.setNumeroErrores(cantidadErrores);

		Errores errores = new Errores();
		detalle.setCodigo(codigo);
		detalle.setOrigen(PROP_ORIGEN_WS + origen.replace("Request", ""));
		errores.getDetalleError().add(detalle);

		excepcion.setErrores(errores);
		return excepcion;
	}

	/**
	 * Se encarga de generar el mensaje de error enviado al cliente.
	 * <li>Historial de Versiones :</li>
	 * <ul>
	 * <li>Autor : Camilo</li>
	 * <li>Version : 1.0.0</li>
	 * <li>Fecha : 26/05/2022</li>
	 * <li>Descripción : Creación del metodo</li>
	 * </ul>
	 * <ul>
	 *
	 * @param codigo Codigo del error
	 * @return objeto excepcion
	 */
	public static final String generarMensajeError(Integer codigoError) {
		String mensaje;

		switch (codigoError) {
			case 502:
				mensaje = PROP_CODIGO_ERROR_502;
				break;

			default:
				mensaje = PROP_CODIGO_ERROR_500;
				break;
		}

		return mensaje;
	}

}
