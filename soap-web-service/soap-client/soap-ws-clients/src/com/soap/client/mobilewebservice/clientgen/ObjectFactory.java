
package com.soap.client.mobilewebservice.clientgen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap.client.mobilewebservice.clientgen package. 
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

    private final static QName _DeleteSubscriberResponse_QNAME = new QName("http://webservice.service.soap.com/", "deleteSubscriberResponse");
    private final static QName _CreateSubscriberResponse_QNAME = new QName("http://webservice.service.soap.com/", "createSubscriberResponse");
    private final static QName _GreetResponse_QNAME = new QName("http://webservice.service.soap.com/", "greetResponse");
    private final static QName _SubscriberNumber_QNAME = new QName("http://custom.namespace.com", "subscriberNumber");
    private final static QName _Credentials_QNAME = new QName("http://webservice.service.soap.com/", "Credentials");
    private final static QName _Username_QNAME = new QName("http://webservice.service.soap.com/", "username");
    private final static QName _GreetUser_QNAME = new QName("http://webservice.service.soap.com/", "greetUser");
    private final static QName _FindSubscriber_QNAME = new QName("http://webservice.service.soap.com/", "findSubscriber");
    private final static QName _GreetUserResponse_QNAME = new QName("http://webservice.service.soap.com/", "greetUserResponse");
    private final static QName _GetSecureToken_QNAME = new QName("http://webservice.service.soap.com/", "getSecureToken");
    private final static QName _CreateSubscriberSecureResponse_QNAME = new QName("http://webservice.service.soap.com/", "createSubscriberSecureResponse");
    private final static QName _GetDummySubscriber_QNAME = new QName("http://webservice.service.soap.com/", "getDummySubscriber");
    private final static QName _SecurityException_QNAME = new QName("http://webservice.service.soap.com/", "SecurityException");
    private final static QName _GetDummySubscriberResponse_QNAME = new QName("http://webservice.service.soap.com/", "getDummySubscriberResponse");
    private final static QName _Greet_QNAME = new QName("http://webservice.service.soap.com/", "greet");
    private final static QName _DeleteSubscriber_QNAME = new QName("http://webservice.service.soap.com/", "deleteSubscriber");
    private final static QName _ThrowErrorResponse_QNAME = new QName("http://webservice.service.soap.com/", "throwErrorResponse");
    private final static QName _Password_QNAME = new QName("http://webservice.service.soap.com/", "password");
    private final static QName _CreateSubscriberSecure_QNAME = new QName("http://webservice.service.soap.com/", "createSubscriberSecure");
    private final static QName _Tokenvalue_QNAME = new QName("http://webservice.service.soap.com/", "tokenvalue");
    private final static QName _GetAllSubscribers_QNAME = new QName("http://webservice.service.soap.com/", "getAllSubscribers");
    private final static QName _CreateSubscriber_QNAME = new QName("http://webservice.service.soap.com/", "createSubscriber");
    private final static QName _FindSubscriberResponse_QNAME = new QName("http://webservice.service.soap.com/", "findSubscriberResponse");
    private final static QName _GetAllSubscribersResponse_QNAME = new QName("http://webservice.service.soap.com/", "getAllSubscribersResponse");
    private final static QName _UserData_QNAME = new QName("http://webservice.service.soap.com/", "UserData");
    private final static QName _ThrowError_QNAME = new QName("http://webservice.service.soap.com/", "throwError");
    private final static QName _GetSecureTokenResponse_QNAME = new QName("http://webservice.service.soap.com/", "getSecureTokenResponse");
    private final static QName _CountAsync_QNAME = new QName("http://webservice.service.soap.com/", "countAsync");
    private final static QName _MobileException_QNAME = new QName("http://webservice.service.soap.com/", "MobileException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.client.mobilewebservice.clientgen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ThrowError }
     * 
     */
    public ThrowError createThrowError() {
        return new ThrowError();
    }

    /**
     * Create an instance of {@link SubscriberData }
     * 
     */
    public SubscriberData createSubscriberData() {
        return new SubscriberData();
    }

    /**
     * Create an instance of {@link MobileSubscriptionException }
     * 
     */
    public MobileSubscriptionException createMobileSubscriptionException() {
        return new MobileSubscriptionException();
    }

    /**
     * Create an instance of {@link GetSecureTokenResponse }
     * 
     */
    public GetSecureTokenResponse createGetSecureTokenResponse() {
        return new GetSecureTokenResponse();
    }

    /**
     * Create an instance of {@link CountAsync }
     * 
     */
    public CountAsync createCountAsync() {
        return new CountAsync();
    }

    /**
     * Create an instance of {@link CreateSubscriberSecure }
     * 
     */
    public CreateSubscriberSecure createCreateSubscriberSecure() {
        return new CreateSubscriberSecure();
    }

    /**
     * Create an instance of {@link GetAllSubscribers }
     * 
     */
    public GetAllSubscribers createGetAllSubscribers() {
        return new GetAllSubscribers();
    }

    /**
     * Create an instance of {@link DeleteSubscriber }
     * 
     */
    public DeleteSubscriber createDeleteSubscriber() {
        return new DeleteSubscriber();
    }

    /**
     * Create an instance of {@link ThrowErrorResponse }
     * 
     */
    public ThrowErrorResponse createThrowErrorResponse() {
        return new ThrowErrorResponse();
    }

    /**
     * Create an instance of {@link GetAllSubscribersResponse }
     * 
     */
    public GetAllSubscribersResponse createGetAllSubscribersResponse() {
        return new GetAllSubscribersResponse();
    }

    /**
     * Create an instance of {@link FindSubscriberResponse }
     * 
     */
    public FindSubscriberResponse createFindSubscriberResponse() {
        return new FindSubscriberResponse();
    }

    /**
     * Create an instance of {@link CreateSubscriber }
     * 
     */
    public CreateSubscriber createCreateSubscriber() {
        return new CreateSubscriber();
    }

    /**
     * Create an instance of {@link FindSubscriber }
     * 
     */
    public FindSubscriber createFindSubscriber() {
        return new FindSubscriber();
    }

    /**
     * Create an instance of {@link Greet }
     * 
     */
    public Greet createGreet() {
        return new Greet();
    }

    /**
     * Create an instance of {@link SecurityException }
     * 
     */
    public SecurityException createSecurityException() {
        return new SecurityException();
    }

    /**
     * Create an instance of {@link GetDummySubscriberResponse }
     * 
     */
    public GetDummySubscriberResponse createGetDummySubscriberResponse() {
        return new GetDummySubscriberResponse();
    }

    /**
     * Create an instance of {@link GetSecureToken }
     * 
     */
    public GetSecureToken createGetSecureToken() {
        return new GetSecureToken();
    }

    /**
     * Create an instance of {@link CreateSubscriberSecureResponse }
     * 
     */
    public CreateSubscriberSecureResponse createCreateSubscriberSecureResponse() {
        return new CreateSubscriberSecureResponse();
    }

    /**
     * Create an instance of {@link GetDummySubscriber }
     * 
     */
    public GetDummySubscriber createGetDummySubscriber() {
        return new GetDummySubscriber();
    }

    /**
     * Create an instance of {@link GreetUserResponse }
     * 
     */
    public GreetUserResponse createGreetUserResponse() {
        return new GreetUserResponse();
    }

    /**
     * Create an instance of {@link GreetResponse }
     * 
     */
    public GreetResponse createGreetResponse() {
        return new GreetResponse();
    }

    /**
     * Create an instance of {@link CreateSubscriberResponse }
     * 
     */
    public CreateSubscriberResponse createCreateSubscriberResponse() {
        return new CreateSubscriberResponse();
    }

    /**
     * Create an instance of {@link DeleteSubscriberResponse }
     * 
     */
    public DeleteSubscriberResponse createDeleteSubscriberResponse() {
        return new DeleteSubscriberResponse();
    }

    /**
     * Create an instance of {@link GreetUser }
     * 
     */
    public GreetUser createGreetUser() {
        return new GreetUser();
    }

    /**
     * Create an instance of {@link SecurityDetails }
     * 
     */
    public SecurityDetails createSecurityDetails() {
        return new SecurityDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSubscriberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "deleteSubscriberResponse")
    public JAXBElement<DeleteSubscriberResponse> createDeleteSubscriberResponse(DeleteSubscriberResponse value) {
        return new JAXBElement<DeleteSubscriberResponse>(_DeleteSubscriberResponse_QNAME, DeleteSubscriberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSubscriberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "createSubscriberResponse")
    public JAXBElement<CreateSubscriberResponse> createCreateSubscriberResponse(CreateSubscriberResponse value) {
        return new JAXBElement<CreateSubscriberResponse>(_CreateSubscriberResponse_QNAME, CreateSubscriberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "greetResponse")
    public JAXBElement<GreetResponse> createGreetResponse(GreetResponse value) {
        return new JAXBElement<GreetResponse>(_GreetResponse_QNAME, GreetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://custom.namespace.com", name = "subscriberNumber")
    public JAXBElement<String> createSubscriberNumber(String value) {
        return new JAXBElement<String>(_SubscriberNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "Credentials")
    public JAXBElement<SecurityDetails> createCredentials(SecurityDetails value) {
        return new JAXBElement<SecurityDetails>(_Credentials_QNAME, SecurityDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "username")
    public JAXBElement<String> createUsername(String value) {
        return new JAXBElement<String>(_Username_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "greetUser")
    public JAXBElement<GreetUser> createGreetUser(GreetUser value) {
        return new JAXBElement<GreetUser>(_GreetUser_QNAME, GreetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSubscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "findSubscriber")
    public JAXBElement<FindSubscriber> createFindSubscriber(FindSubscriber value) {
        return new JAXBElement<FindSubscriber>(_FindSubscriber_QNAME, FindSubscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "greetUserResponse")
    public JAXBElement<GreetUserResponse> createGreetUserResponse(GreetUserResponse value) {
        return new JAXBElement<GreetUserResponse>(_GreetUserResponse_QNAME, GreetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecureToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "getSecureToken")
    public JAXBElement<GetSecureToken> createGetSecureToken(GetSecureToken value) {
        return new JAXBElement<GetSecureToken>(_GetSecureToken_QNAME, GetSecureToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSubscriberSecureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "createSubscriberSecureResponse")
    public JAXBElement<CreateSubscriberSecureResponse> createCreateSubscriberSecureResponse(CreateSubscriberSecureResponse value) {
        return new JAXBElement<CreateSubscriberSecureResponse>(_CreateSubscriberSecureResponse_QNAME, CreateSubscriberSecureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDummySubscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "getDummySubscriber")
    public JAXBElement<GetDummySubscriber> createGetDummySubscriber(GetDummySubscriber value) {
        return new JAXBElement<GetDummySubscriber>(_GetDummySubscriber_QNAME, GetDummySubscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "SecurityException")
    public JAXBElement<SecurityException> createSecurityException(SecurityException value) {
        return new JAXBElement<SecurityException>(_SecurityException_QNAME, SecurityException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDummySubscriberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "getDummySubscriberResponse")
    public JAXBElement<GetDummySubscriberResponse> createGetDummySubscriberResponse(GetDummySubscriberResponse value) {
        return new JAXBElement<GetDummySubscriberResponse>(_GetDummySubscriberResponse_QNAME, GetDummySubscriberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Greet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "greet")
    public JAXBElement<Greet> createGreet(Greet value) {
        return new JAXBElement<Greet>(_Greet_QNAME, Greet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSubscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "deleteSubscriber")
    public JAXBElement<DeleteSubscriber> createDeleteSubscriber(DeleteSubscriber value) {
        return new JAXBElement<DeleteSubscriber>(_DeleteSubscriber_QNAME, DeleteSubscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ThrowErrorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "throwErrorResponse")
    public JAXBElement<ThrowErrorResponse> createThrowErrorResponse(ThrowErrorResponse value) {
        return new JAXBElement<ThrowErrorResponse>(_ThrowErrorResponse_QNAME, ThrowErrorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSubscriberSecure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "createSubscriberSecure")
    public JAXBElement<CreateSubscriberSecure> createCreateSubscriberSecure(CreateSubscriberSecure value) {
        return new JAXBElement<CreateSubscriberSecure>(_CreateSubscriberSecure_QNAME, CreateSubscriberSecure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "tokenvalue")
    public JAXBElement<String> createTokenvalue(String value) {
        return new JAXBElement<String>(_Tokenvalue_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSubscribers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "getAllSubscribers")
    public JAXBElement<GetAllSubscribers> createGetAllSubscribers(GetAllSubscribers value) {
        return new JAXBElement<GetAllSubscribers>(_GetAllSubscribers_QNAME, GetAllSubscribers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSubscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "createSubscriber")
    public JAXBElement<CreateSubscriber> createCreateSubscriber(CreateSubscriber value) {
        return new JAXBElement<CreateSubscriber>(_CreateSubscriber_QNAME, CreateSubscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSubscriberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "findSubscriberResponse")
    public JAXBElement<FindSubscriberResponse> createFindSubscriberResponse(FindSubscriberResponse value) {
        return new JAXBElement<FindSubscriberResponse>(_FindSubscriberResponse_QNAME, FindSubscriberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSubscribersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "getAllSubscribersResponse")
    public JAXBElement<GetAllSubscribersResponse> createGetAllSubscribersResponse(GetAllSubscribersResponse value) {
        return new JAXBElement<GetAllSubscribersResponse>(_GetAllSubscribersResponse_QNAME, GetAllSubscribersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriberData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "UserData")
    public JAXBElement<SubscriberData> createUserData(SubscriberData value) {
        return new JAXBElement<SubscriberData>(_UserData_QNAME, SubscriberData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ThrowError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "throwError")
    public JAXBElement<ThrowError> createThrowError(ThrowError value) {
        return new JAXBElement<ThrowError>(_ThrowError_QNAME, ThrowError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecureTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "getSecureTokenResponse")
    public JAXBElement<GetSecureTokenResponse> createGetSecureTokenResponse(GetSecureTokenResponse value) {
        return new JAXBElement<GetSecureTokenResponse>(_GetSecureTokenResponse_QNAME, GetSecureTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountAsync }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "countAsync")
    public JAXBElement<CountAsync> createCountAsync(CountAsync value) {
        return new JAXBElement<CountAsync>(_CountAsync_QNAME, CountAsync.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MobileSubscriptionException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.service.soap.com/", name = "MobileException")
    public JAXBElement<MobileSubscriptionException> createMobileException(MobileSubscriptionException value) {
        return new JAXBElement<MobileSubscriptionException>(_MobileException_QNAME, MobileSubscriptionException.class, null, value);
    }

}
