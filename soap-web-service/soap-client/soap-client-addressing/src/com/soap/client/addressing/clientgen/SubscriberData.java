
package com.soap.client.addressing.clientgen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for subscriberData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscriberData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="billCycle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="connectionStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postpaid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscriberData", propOrder = {
    "billCycle",
    "connectionStartDate",
    "msisdn",
    "offer",
    "postpaid"
})
public class SubscriberData {

    protected int billCycle;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar connectionStartDate;
    protected String msisdn;
    protected String offer;
    protected boolean postpaid;

    /**
     * Gets the value of the billCycle property.
     * 
     */
    public int getBillCycle() {
        return billCycle;
    }

    /**
     * Sets the value of the billCycle property.
     * 
     */
    public void setBillCycle(int value) {
        this.billCycle = value;
    }

    /**
     * Gets the value of the connectionStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConnectionStartDate() {
        return connectionStartDate;
    }

    /**
     * Sets the value of the connectionStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConnectionStartDate(XMLGregorianCalendar value) {
        this.connectionStartDate = value;
    }

    /**
     * Gets the value of the msisdn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsisdn() {
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
    public void setMsisdn(String value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the offer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffer() {
        return offer;
    }

    /**
     * Sets the value of the offer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffer(String value) {
        this.offer = value;
    }

    /**
     * Gets the value of the postpaid property.
     * 
     */
    public boolean isPostpaid() {
        return postpaid;
    }

    /**
     * Sets the value of the postpaid property.
     * 
     */
    public void setPostpaid(boolean value) {
        this.postpaid = value;
    }

}
