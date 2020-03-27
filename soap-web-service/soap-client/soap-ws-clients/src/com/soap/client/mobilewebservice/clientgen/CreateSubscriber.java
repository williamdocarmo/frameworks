
package com.soap.client.mobilewebservice.clientgen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createSubscriber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createSubscriber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createSubscriberRequest" type="{http://webservice.service.soap.com/}subscriberData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createSubscriber", propOrder = {
    "createSubscriberRequest"
})
public class CreateSubscriber {

    protected SubscriberData createSubscriberRequest;

    /**
     * Gets the value of the createSubscriberRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberData }
     *     
     */
    public SubscriberData getCreateSubscriberRequest() {
        return createSubscriberRequest;
    }

    /**
     * Sets the value of the createSubscriberRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberData }
     *     
     */
    public void setCreateSubscriberRequest(SubscriberData value) {
        this.createSubscriberRequest = value;
    }

}
