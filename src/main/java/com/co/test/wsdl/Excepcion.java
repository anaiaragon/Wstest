
package com.co.test.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Excepcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Excepcion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="formato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="correlativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroErrores" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="errores" type="{http://integracion.coopeuch.cl/wstest/}Errores" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Excepcion", propOrder = {
    "formato",
    "identificador",
    "correlativo",
    "numeroErrores",
    "errores"
})
public class Excepcion {

    protected String formato;
    protected String identificador;
    protected String correlativo;
    protected Integer numeroErrores;
    protected Errores errores;

    /**
     * Obtiene el valor de la propiedad formato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Define el valor de la propiedad formato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormato(String value) {
        this.formato = value;
    }

    /**
     * Obtiene el valor de la propiedad identificador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Define el valor de la propiedad identificador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificador(String value) {
        this.identificador = value;
    }

    /**
     * Obtiene el valor de la propiedad correlativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelativo() {
        return correlativo;
    }

    /**
     * Define el valor de la propiedad correlativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelativo(String value) {
        this.correlativo = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroErrores.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroErrores() {
        return numeroErrores;
    }

    /**
     * Define el valor de la propiedad numeroErrores.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroErrores(Integer value) {
        this.numeroErrores = value;
    }

    /**
     * Obtiene el valor de la propiedad errores.
     * 
     * @return
     *     possible object is
     *     {@link Errores }
     *     
     */
    public Errores getErrores() {
        return errores;
    }

    /**
     * Define el valor de la propiedad errores.
     * 
     * @param value
     *     allowed object is
     *     {@link Errores }
     *     
     */
    public void setErrores(Errores value) {
        this.errores = value;
    }

}
