
package com.app.client.stubs.subscriber;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createMobileSubscriber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createMobileSubscriber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubscriberInfo" type="{http://service.mobile.com}subscriber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createMobileSubscriber", propOrder = {
    "subscriberInfo"
})
public class CreateMobileSubscriber {

    @XmlElement(name = "SubscriberInfo")
    protected Subscriber subscriberInfo;

    /**
     * Gets the value of the subscriberInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Subscriber }
     *     
     */
    public Subscriber getSubscriberInfo() {
        return subscriberInfo;
    }

    /**
     * Sets the value of the subscriberInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscriber }
     *     
     */
    public void setSubscriberInfo(Subscriber value) {
        this.subscriberInfo = value;
    }

}
