
package com.app.client.stubs.subscriber;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createMobileSubscriberResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createMobileSubscriberResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="affectedRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createMobileSubscriberResponse", propOrder = {
    "affectedRows"
})
public class CreateMobileSubscriberResponse {

    protected int affectedRows;

    /**
     * Gets the value of the affectedRows property.
     * 
     */
    public int getAffectedRows() {
        return affectedRows;
    }

    /**
     * Sets the value of the affectedRows property.
     * 
     */
    public void setAffectedRows(int value) {
        this.affectedRows = value;
    }

}
