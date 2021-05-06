
package com.app.client.stubs.subscriber;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.app.client.stubs.subscriber package. 
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

    private final static QName _SubscriberInformation_QNAME = new QName("http://service.mobile.com", "SubscriberInformation");
    private final static QName _CreateMobileSubscriber_QNAME = new QName("http://service.mobile.com", "createMobileSubscriber");
    private final static QName _SubscriberNotFoundException_QNAME = new QName("http://service.mobile.com", "SubscriberNotFoundException");
    private final static QName _GetMobileSubscriberByIMSI_QNAME = new QName("http://service.mobile.com", "getMobileSubscriberByIMSI");
    private final static QName _Authentication_QNAME = new QName("http://service.mobile.com", "authentication");
    private final static QName _GetMobileSubscriberByMSISDN_QNAME = new QName("http://service.mobile.com", "getMobileSubscriberByMSISDN");
    private final static QName _Timestamp_QNAME = new QName("http://service.mobile.com", "timestamp");
    private final static QName _Username_QNAME = new QName("http://service.mobile.com", "username");
    private final static QName _CreateMobileSubscriberResponse_QNAME = new QName("http://service.mobile.com", "createMobileSubscriberResponse");
    private final static QName _PerformBatchOperation_QNAME = new QName("http://service.mobile.com", "performBatchOperation");
    private final static QName _VOLTE_QNAME = new QName("newns", "VOLTE");
    private final static QName _GetMobileSubscriberByIMSIResponse_QNAME = new QName("http://service.mobile.com", "getMobileSubscriberByIMSIResponse");
    private final static QName _GetAllMobileSubscribers_QNAME = new QName("http://service.mobile.com", "getAllMobileSubscribers");
    private final static QName _Password_QNAME = new QName("http://service.mobile.com", "password");
    private final static QName _PerformBatchOperationResponse_QNAME = new QName("http://service.mobile.com", "performBatchOperationResponse");
    private final static QName _DeleteMobileSubscriber_QNAME = new QName("http://service.mobile.com", "deleteMobileSubscriber");
    private final static QName _GetAllMobileSubscribersResponse_QNAME = new QName("http://service.mobile.com", "getAllMobileSubscribersResponse");
    private final static QName _GetMobileSubscriberByMSISDNResponse_QNAME = new QName("http://service.mobile.com", "getMobileSubscriberByMSISDNResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.app.client.stubs.subscriber
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMobileSubscriberByIMSI }
     * 
     */
    public GetMobileSubscriberByIMSI createGetMobileSubscriberByIMSI() {
        return new GetMobileSubscriberByIMSI();
    }

    /**
     * Create an instance of {@link SubscriberNotFoundException }
     * 
     */
    public SubscriberNotFoundException createSubscriberNotFoundException() {
        return new SubscriberNotFoundException();
    }

    /**
     * Create an instance of {@link CreateMobileSubscriber }
     * 
     */
    public CreateMobileSubscriber createCreateMobileSubscriber() {
        return new CreateMobileSubscriber();
    }

    /**
     * Create an instance of {@link Subscriber }
     * 
     */
    public Subscriber createSubscriber() {
        return new Subscriber();
    }

    /**
     * Create an instance of {@link DeleteMobileSubscriber }
     * 
     */
    public DeleteMobileSubscriber createDeleteMobileSubscriber() {
        return new DeleteMobileSubscriber();
    }

    /**
     * Create an instance of {@link GetAllMobileSubscribersResponse }
     * 
     */
    public GetAllMobileSubscribersResponse createGetAllMobileSubscribersResponse() {
        return new GetAllMobileSubscribersResponse();
    }

    /**
     * Create an instance of {@link GetMobileSubscriberByMSISDNResponse }
     * 
     */
    public GetMobileSubscriberByMSISDNResponse createGetMobileSubscriberByMSISDNResponse() {
        return new GetMobileSubscriberByMSISDNResponse();
    }

    /**
     * Create an instance of {@link GetAllMobileSubscribers }
     * 
     */
    public GetAllMobileSubscribers createGetAllMobileSubscribers() {
        return new GetAllMobileSubscribers();
    }

    /**
     * Create an instance of {@link PerformBatchOperationResponse }
     * 
     */
    public PerformBatchOperationResponse createPerformBatchOperationResponse() {
        return new PerformBatchOperationResponse();
    }

    /**
     * Create an instance of {@link GetMobileSubscriberByIMSIResponse }
     * 
     */
    public GetMobileSubscriberByIMSIResponse createGetMobileSubscriberByIMSIResponse() {
        return new GetMobileSubscriberByIMSIResponse();
    }

    /**
     * Create an instance of {@link CreateMobileSubscriberResponse }
     * 
     */
    public CreateMobileSubscriberResponse createCreateMobileSubscriberResponse() {
        return new CreateMobileSubscriberResponse();
    }

    /**
     * Create an instance of {@link PerformBatchOperation }
     * 
     */
    public PerformBatchOperation createPerformBatchOperation() {
        return new PerformBatchOperation();
    }

    /**
     * Create an instance of {@link AuthenticationData }
     * 
     */
    public AuthenticationData createAuthenticationData() {
        return new AuthenticationData();
    }

    /**
     * Create an instance of {@link GetMobileSubscriberByMSISDN }
     * 
     */
    public GetMobileSubscriberByMSISDN createGetMobileSubscriberByMSISDN() {
        return new GetMobileSubscriberByMSISDN();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "SubscriberInformation")
    public JAXBElement<Subscriber> createSubscriberInformation(Subscriber value) {
        return new JAXBElement<Subscriber>(_SubscriberInformation_QNAME, Subscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMobileSubscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "createMobileSubscriber")
    public JAXBElement<CreateMobileSubscriber> createCreateMobileSubscriber(CreateMobileSubscriber value) {
        return new JAXBElement<CreateMobileSubscriber>(_CreateMobileSubscriber_QNAME, CreateMobileSubscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriberNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "SubscriberNotFoundException")
    public JAXBElement<SubscriberNotFoundException> createSubscriberNotFoundException(SubscriberNotFoundException value) {
        return new JAXBElement<SubscriberNotFoundException>(_SubscriberNotFoundException_QNAME, SubscriberNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMobileSubscriberByIMSI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "getMobileSubscriberByIMSI")
    public JAXBElement<GetMobileSubscriberByIMSI> createGetMobileSubscriberByIMSI(GetMobileSubscriberByIMSI value) {
        return new JAXBElement<GetMobileSubscriberByIMSI>(_GetMobileSubscriberByIMSI_QNAME, GetMobileSubscriberByIMSI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "authentication")
    public JAXBElement<AuthenticationData> createAuthentication(AuthenticationData value) {
        return new JAXBElement<AuthenticationData>(_Authentication_QNAME, AuthenticationData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMobileSubscriberByMSISDN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "getMobileSubscriberByMSISDN")
    public JAXBElement<GetMobileSubscriberByMSISDN> createGetMobileSubscriberByMSISDN(GetMobileSubscriberByMSISDN value) {
        return new JAXBElement<GetMobileSubscriberByMSISDN>(_GetMobileSubscriberByMSISDN_QNAME, GetMobileSubscriberByMSISDN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "timestamp")
    public JAXBElement<String> createTimestamp(String value) {
        return new JAXBElement<String>(_Timestamp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "username")
    public JAXBElement<String> createUsername(String value) {
        return new JAXBElement<String>(_Username_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMobileSubscriberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "createMobileSubscriberResponse")
    public JAXBElement<CreateMobileSubscriberResponse> createCreateMobileSubscriberResponse(CreateMobileSubscriberResponse value) {
        return new JAXBElement<CreateMobileSubscriberResponse>(_CreateMobileSubscriberResponse_QNAME, CreateMobileSubscriberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PerformBatchOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "performBatchOperation")
    public JAXBElement<PerformBatchOperation> createPerformBatchOperation(PerformBatchOperation value) {
        return new JAXBElement<PerformBatchOperation>(_PerformBatchOperation_QNAME, PerformBatchOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "newns", name = "VOLTE")
    public JAXBElement<String> createVOLTE(String value) {
        return new JAXBElement<String>(_VOLTE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMobileSubscriberByIMSIResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "getMobileSubscriberByIMSIResponse")
    public JAXBElement<GetMobileSubscriberByIMSIResponse> createGetMobileSubscriberByIMSIResponse(GetMobileSubscriberByIMSIResponse value) {
        return new JAXBElement<GetMobileSubscriberByIMSIResponse>(_GetMobileSubscriberByIMSIResponse_QNAME, GetMobileSubscriberByIMSIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMobileSubscribers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "getAllMobileSubscribers")
    public JAXBElement<GetAllMobileSubscribers> createGetAllMobileSubscribers(GetAllMobileSubscribers value) {
        return new JAXBElement<GetAllMobileSubscribers>(_GetAllMobileSubscribers_QNAME, GetAllMobileSubscribers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PerformBatchOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "performBatchOperationResponse")
    public JAXBElement<PerformBatchOperationResponse> createPerformBatchOperationResponse(PerformBatchOperationResponse value) {
        return new JAXBElement<PerformBatchOperationResponse>(_PerformBatchOperationResponse_QNAME, PerformBatchOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMobileSubscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "deleteMobileSubscriber")
    public JAXBElement<DeleteMobileSubscriber> createDeleteMobileSubscriber(DeleteMobileSubscriber value) {
        return new JAXBElement<DeleteMobileSubscriber>(_DeleteMobileSubscriber_QNAME, DeleteMobileSubscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMobileSubscribersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "getAllMobileSubscribersResponse")
    public JAXBElement<GetAllMobileSubscribersResponse> createGetAllMobileSubscribersResponse(GetAllMobileSubscribersResponse value) {
        return new JAXBElement<GetAllMobileSubscribersResponse>(_GetAllMobileSubscribersResponse_QNAME, GetAllMobileSubscribersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMobileSubscriberByMSISDNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.mobile.com", name = "getMobileSubscriberByMSISDNResponse")
    public JAXBElement<GetMobileSubscriberByMSISDNResponse> createGetMobileSubscriberByMSISDNResponse(GetMobileSubscriberByMSISDNResponse value) {
        return new JAXBElement<GetMobileSubscriberByMSISDNResponse>(_GetMobileSubscriberByMSISDNResponse_QNAME, GetMobileSubscriberByMSISDNResponse.class, null, value);
    }

}
