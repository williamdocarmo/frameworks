
package com.soap.client.mobilewebservice.clientgen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findSubscriberResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findSubscriberResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createSubscriberSecureResponse" type="{http://webservice.service.soap.com/}subscriberData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findSubscriberResponse", propOrder = {
    "createSubscriberSecureResponse"
})
public class FindSubscriberResponse {

    protected SubscriberData createSubscriberSecureResponse;

    /**
     * Gets the value of the createSubscriberSecureResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberData }
     *     
     */
    public SubscriberData getCreateSubscriberSecureResponse() {
        return createSubscriberSecureResponse;
    }

    /**
     * Sets the value of the createSubscriberSecureResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberData }
     *     
     */
    public void setCreateSubscriberSecureResponse(SubscriberData value) {
        this.createSubscriberSecureResponse = value;
    }

}
