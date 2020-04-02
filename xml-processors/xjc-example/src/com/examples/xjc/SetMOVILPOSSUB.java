//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.02 at 05:37:56 PM IST 
//


package com.examples.xjc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="MSISDN" type="{http://schemas.ericsson.com/ma/cai/1.0/}MSISDNType"/>
 *         &lt;element name="NEWMSISDN" type="{http://schemas.ericsson.com/ma/cai/1.0/}MSISDNType" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://schemas.ericsson.com/ma/cai/1.0/}StatusType" minOccurs="0"/>
 *         &lt;element name="NewSupervisionPeriodExpiryDate" type="{http://schemas.ericsson.com/ma/cai/1.0/}AIRDateType" minOccurs="0"/>
 *         &lt;element name="NewServiceFeePeriodExpiryDate" type="{http://schemas.ericsson.com/ma/cai/1.0/}AIRDateType" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://schemas.ericsson.com/ma/cai/1.0/}CurrencyType" minOccurs="0"/>
 *         &lt;element name="ServiceClass" type="{http://schemas.ericsson.com/ma/cai/1.0/}int" minOccurs="0"/>
 *         &lt;element name="NewServiceClass" type="{http://schemas.ericsson.com/ma/cai/1.0/}int" minOccurs="0"/>
 *         &lt;element name="ServiceClassTemporary" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" minOccurs="0"/>
 *         &lt;element name="TempServiceClassExpDate" type="{http://schemas.ericsson.com/ma/cai/1.0/}AIRDateType" minOccurs="0"/>
 *         &lt;element name="PinCode" type="{http://schemas.ericsson.com/ma/cai/1.0/}int" minOccurs="0"/>
 *         &lt;element name="DedicatedAccounts" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMaps" minOccurs="0"/>
 *         &lt;element name="Accumulators" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Offers" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PAM" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RUNPAM" type="{http://schemas.ericsson.com/ma/cai/1.0/}int" minOccurs="0"/>
 *         &lt;element name="SHAREACCOUNT" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FAF" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Package" type="{http://schemas.ericsson.com/ma/cai/1.0/}string" minOccurs="0"/>
 *         &lt;element name="PackagePrice" type="{http://schemas.ericsson.com/ma/cai/1.0/}MoneyType" minOccurs="0"/>
 *         &lt;element name="ChargingType" type="{http://schemas.ericsson.com/ma/cai/1.0/}int" minOccurs="0"/>
 *         &lt;element name="ChargingIndicator" type="{http://schemas.ericsson.com/ma/cai/1.0/}int" minOccurs="0"/>
 *         &lt;element name="AdjustmentAmount" type="{http://schemas.ericsson.com/ma/cai/1.0/}MoneyType" minOccurs="0"/>
 *         &lt;element name="Action" type="{http://schemas.ericsson.com/ma/cai/1.0/}AdjustmentActionType" minOccurs="0"/>
 *         &lt;element name="PaymentProfile" type="{http://schemas.ericsson.com/ma/cai/1.0/}PaymentProfileType" minOccurs="0"/>
 *         &lt;element name="TransactionAmount" type="{http://schemas.ericsson.com/ma/cai/1.0/}MoneyType" minOccurs="0"/>
 *         &lt;element name="REASONID" type="{http://schemas.ericsson.com/ma/cai/1.0/}ReasonType" minOccurs="0"/>
 *         &lt;element name="APPINFO" type="{http://schemas.ericsson.com/ma/cai/1.0/}string" minOccurs="0"/>
 *         &lt;element name="OperatorID" type="{http://schemas.ericsson.com/ma/cai/1.0/}string" minOccurs="0"/>
 *         &lt;element name="Paquete" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CommunityIdListNew" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMaps" minOccurs="0"/>
 *         &lt;element name="Profile" type="{http://schemas.ericsson.com/ma/cai/1.0/}int" minOccurs="0"/>
 *         &lt;element name="IMSI" type="{http://schemas.ericsson.com/ma/cai/1.0/}IMSIType" minOccurs="0"/>
 *         &lt;element name="GPRS" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" minOccurs="0"/>
 *         &lt;element name="HLR" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMaps" minOccurs="0"/>
 *         &lt;element name="AIRHLR" type="{http://schemas.ericsson.com/ma/cai/1.0/}AIRHLRType" minOccurs="0"/>
 *         &lt;element name="USERTYPE" type="{http://schemas.ericsson.com/ma/cai/1.0/}UserType" minOccurs="0"/>
 *         &lt;element name="LTE" type="{http://schemas.ericsson.com/ma/cai/1.0/}ValueMapsOperation" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "msisdnOrNEWMSISDNOrStatus"
})
@XmlRootElement(name = "SetMOVILPOSSUB")
public class SetMOVILPOSSUB {

    @XmlElementRefs({
        @XmlElementRef(name = "PinCode", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CommunityIdListNew", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NewServiceClass", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FAF", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PaymentProfile", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LTE", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SHAREACCOUNT", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Currency", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ServiceClass", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TransactionAmount", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IMSI", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Accumulators", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TempServiceClassExpDate", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ChargingIndicator", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NewSupervisionPeriodExpiryDate", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Profile", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ServiceClassTemporary", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PackagePrice", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NewServiceFeePeriodExpiryDate", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GPRS", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PAM", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RUNPAM", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OperatorID", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AdjustmentAmount", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MSISDN", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Offers", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DedicatedAccounts", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Package", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NEWMSISDN", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Paquete", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HLR", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Status", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Action", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ChargingType", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "REASONID", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AIRHLR", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "APPINFO", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "USERTYPE", namespace = "http://schemas.ericsson.com/ma/cai/1.0/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> msisdnOrNEWMSISDNOrStatus;

    /**
     * Gets the value of the msisdnOrNEWMSISDNOrStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the msisdnOrNEWMSISDNOrStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMSISDNOrNEWMSISDNOrStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMaps }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMaps }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMapsOperation }{@code >}
     * {@link JAXBElement }{@code <}{@link ValueMaps }{@code >}
     * {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     * {@link JAXBElement }{@code <}{@link AdjustmentActionType }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getMSISDNOrNEWMSISDNOrStatus() {
        if (msisdnOrNEWMSISDNOrStatus == null) {
            msisdnOrNEWMSISDNOrStatus = new ArrayList<JAXBElement<?>>();
        }
        return this.msisdnOrNEWMSISDNOrStatus;
    }

}
