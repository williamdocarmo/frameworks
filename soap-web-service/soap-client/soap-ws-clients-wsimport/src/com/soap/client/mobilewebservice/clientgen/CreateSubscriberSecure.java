
package com.soap.client.mobilewebservice.clientgen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createSubscriberSecure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createSubscriberSecure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createSubscriberSecureRequest" type="{http://webservice.service.soap.com/}subscriberData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createSubscriberSecure", propOrder = {
    "createSubscriberSecureRequest"
})
public class CreateSubscriberSecure {

    protected SubscriberData createSubscriberSecureRequest;

    /**
     * Gets the value of the createSubscriberSecureRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberData }
     *     
     */
    public SubscriberData getCreateSubscriberSecureRequest() {
        return createSubscriberSecureRequest;
    }

    /**
     * Sets the value of the createSubscriberSecureRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberData }
     *     
     */
    public void setCreateSubscriberSecureRequest(SubscriberData value) {
        this.createSubscriberSecureRequest = value;
    }

}
