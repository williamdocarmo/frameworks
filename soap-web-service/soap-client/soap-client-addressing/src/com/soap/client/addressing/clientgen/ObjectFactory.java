
package com.soap.client.addressing.clientgen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap.client.addressing.clientgen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindSubscriber_QNAME = new QName("http://address.service.soap.com/", "findSubscriber");
    private final static QName _FindSubscriberResponse_QNAME = new QName("http://address.service.soap.com/", "findSubscriberResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.client.addressing.clientgen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindSubscriber }
     * 
     */
    public FindSubscriber createFindSubscriber() {
        return new FindSubscriber();
    }

    /**
     * Create an instance of {@link FindSubscriberResponse }
     * 
     */
    public FindSubscriberResponse createFindSubscriberResponse() {
        return new FindSubscriberResponse();
    }

    /**
     * Create an instance of {@link SubscriberData }
     * 
     */
    public SubscriberData createSubscriberData() {
        return new SubscriberData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSubscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://address.service.soap.com/", name = "findSubscriber")
    public JAXBElement<FindSubscriber> createFindSubscriber(FindSubscriber value) {
        return new JAXBElement<FindSubscriber>(_FindSubscriber_QNAME, FindSubscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSubscriberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://address.service.soap.com/", name = "findSubscriberResponse")
    public JAXBElement<FindSubscriberResponse> createFindSubscriberResponse(FindSubscriberResponse value) {
        return new JAXBElement<FindSubscriberResponse>(_FindSubscriberResponse_QNAME, FindSubscriberResponse.class, null, value);
    }

}
