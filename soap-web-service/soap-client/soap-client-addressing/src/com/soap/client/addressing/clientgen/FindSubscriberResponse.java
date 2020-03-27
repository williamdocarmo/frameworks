
package com.soap.client.addressing.clientgen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GetSubscriber" type="{http://address.service.soap.com/}subscriberData" minOccurs="0"/>
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
    "getSubscriber"
})
public class FindSubscriberResponse {

    @XmlElement(name = "GetSubscriber")
    protected SubscriberData getSubscriber;

    /**
     * Gets the value of the getSubscriber property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberData }
     *     
     */
    public SubscriberData getGetSubscriber() {
        return getSubscriber;
    }

    /**
     * Sets the value of the getSubscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberData }
     *     
     */
    public void setGetSubscriber(SubscriberData value) {
        this.getSubscriber = value;
    }

}
