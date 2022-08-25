
package com.co.test.wsdl;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.co.test.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.co.test.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrearRequest }
     * 
     */
    public CrearRequest createCrearRequest() {
        return new CrearRequest();
    }

    /**
     * Create an instance of {@link CrearResponse }
     * 
     */
    public CrearResponse createCrearResponse() {
        return new CrearResponse();
    }

    /**
     * Create an instance of {@link Excepcion }
     * 
     */
    public Excepcion createExcepcion() {
        return new Excepcion();
    }

    /**
     * Create an instance of {@link ActualizarRequest }
     * 
     */
    public ActualizarRequest createActualizarRequest() {
        return new ActualizarRequest();
    }

    /**
     * Create an instance of {@link ActualizarResponse }
     * 
     */
    public ActualizarResponse createActualizarResponse() {
        return new ActualizarResponse();
    }

    /**
     * Create an instance of {@link ConsultarRequest }
     * 
     */
    public ConsultarRequest createConsultarRequest() {
        return new ConsultarRequest();
    }

    /**
     * Create an instance of {@link ConsultarResponse }
     * 
     */
    public ConsultarResponse createConsultarResponse() {
        return new ConsultarResponse();
    }

    /**
     * Create an instance of {@link Errores }
     * 
     */
    public Errores createErrores() {
        return new Errores();
    }

    /**
     * Create an instance of {@link DetalleError }
     * 
     */
    public DetalleError createDetalleError() {
        return new DetalleError();
    }

}
