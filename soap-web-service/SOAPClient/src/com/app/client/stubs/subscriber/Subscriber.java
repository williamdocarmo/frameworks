
package com.app.client.stubs.subscriber;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subscriber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscriber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VOICE_2G" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{newns}VOLTE" minOccurs="0"/>
 *         &lt;element name="SMS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MSISDN" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IMSI" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscriber", propOrder = {
    "voice2G",
    "volte",
    "sms"
})
public class Subscriber {

    @XmlElement(name = "VOICE_2G")
    protected String voice2G;
    @XmlElement(name = "VOLTE", namespace = "newns")
    protected String volte;
    @XmlElement(name = "SMS")
    protected String sms;
    @XmlAttribute(name = "MSISDN")
    protected String msisdn;
    @XmlAttribute(name = "IMSI")
    protected String imsi;

    /**
     * Gets the value of the voice2G property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVOICE2G() {
        return voice2G;
    }

    /**
     * Sets the value of the voice2G property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVOICE2G(String value) {
        this.voice2G = value;
    }

    /**
     * Gets the value of the volte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVOLTE() {
        return volte;
    }

    /**
     * Sets the value of the volte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVOLTE(String value) {
        this.volte = value;
    }

    /**
     * Gets the value of the sms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMS() {
        return sms;
    }

    /**
     * Sets the value of the sms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMS(String value) {
        this.sms = value;
    }

    /**
     * Gets the value of the msisdn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSISDN() {
        return msisdn;
    }

    /**
     * Sets the value of the msisdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSISDN(String value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the imsi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMSI() {
        return imsi;
    }

    /**
     * Sets the value of the imsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMSI(String value) {
        this.imsi = value;
    }

}
