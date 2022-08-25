
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.co.test.wsdl;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.9
 * 2022-05-30T17:01:48.013-05:00
 * Generated source version: 3.1.9
 * Author: Ana Aragon
 * 
 */

@javax.jws.WebService(
                      serviceName = "wstest",
                      portName = "wstestPort",
                      targetNamespace = "http://integracion.coopeuch.cl/wstest/",
                      wsdlLocation = "classpath:etc/wsdl/wstest.wsdl",
                      endpointInterface = "com.co.test.wsdl.WstestSOAPPortType")
                      
public class WstestPortImpl implements WstestSOAPPortType {

    private static final Logger LOG = Logger.getLogger(WstestPortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.co.test.wsdl.WstestSOAPPortType#consultar(com.co.test.wsdl.ConsultarRequest parameters)*
     */
    public com.co.test.wsdl.ConsultarResponse consultar(ConsultarRequest parameters) { 
        LOG.info("Executing operation consultar");
        System.out.println(parameters);
        try {
            com.co.test.wsdl.ConsultarResponse _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.co.test.wsdl.WstestSOAPPortType#crear(com.co.test.wsdl.CrearRequest parameters)*
     */
    public com.co.test.wsdl.CrearResponse crear(CrearRequest parameters) { 
        LOG.info("Executing operation crear");
        System.out.println(parameters);
        try {
            com.co.test.wsdl.CrearResponse _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.co.test.wsdl.WstestSOAPPortType#actualizar(com.co.test.wsdl.ActualizarRequest parameters)*
     */
    public com.co.test.wsdl.ActualizarResponse actualizar(ActualizarRequest parameters) { 
        LOG.info("Executing operation actualizar");
        System.out.println(parameters);
        try {
            com.co.test.wsdl.ActualizarResponse _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}