
package com.co.test.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="canalLlamada" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cedula" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="salario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userId",
    "canalLlamada",
    "cedula",
    "nombre",
    "salario"
})
@XmlRootElement(name = "consultarRequest")
public class ConsultarRequest {

    @XmlElement(required = true)
    protected String userId;
    @XmlElement(required = true)
    protected String canalLlamada;
    @XmlElement(required = true)
    protected String cedula;
    @XmlElement(required = true)
    protected String nombre;
    protected int salario;

    /**
     * Obtiene el valor de la propiedad userId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Define el valor de la propiedad userId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Obtiene el valor de la propiedad canalLlamada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanalLlamada() {
        return canalLlamada;
    }

    /**
     * Define el valor de la propiedad canalLlamada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanalLlamada(String value) {
        this.canalLlamada = value;
    }

    /**
     * Obtiene el valor de la propiedad cedula.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Define el valor de la propiedad cedula.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCedula(String value) {
        this.cedula = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad salario.
     * 
     */
    public int getSalario() {
        return salario;
    }

    /**
     * Define el valor de la propiedad salario.
     * 
     */
    public void setSalario(int value) {
        this.salario = value;
    }

}
