
package com.app.client.stubs.mtom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.app.client.stubs.mtom package. 
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

    private final static QName _FileDownload_QNAME = new QName("http://example.org", "fileDownload");
    private final static QName _FileDownloadResponse_QNAME = new QName("http://example.org", "fileDownloadResponse");
    private final static QName _FileUploadResponse_QNAME = new QName("http://example.org", "fileUploadResponse");
    private final static QName _FileUpload_QNAME = new QName("http://example.org", "fileUpload");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.app.client.stubs.mtom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FileDownload }
     * 
     */
    public FileDownload createFileDownload() {
        return new FileDownload();
    }

    /**
     * Create an instance of {@link FileDownloadResponse }
     * 
     */
    public FileDownloadResponse createFileDownloadResponse() {
        return new FileDownloadResponse();
    }

    /**
     * Create an instance of {@link FileUploadResponse }
     * 
     */
    public FileUploadResponse createFileUploadResponse() {
        return new FileUploadResponse();
    }

    /**
     * Create an instance of {@link FileUpload }
     * 
     */
    public FileUpload createFileUpload() {
        return new FileUpload();
    }

    /**
     * Create an instance of {@link Base64Binary }
     * 
     */
    public Base64Binary createBase64Binary() {
        return new Base64Binary();
    }

    /**
     * Create an instance of {@link HexBinary }
     * 
     */
    public HexBinary createHexBinary() {
        return new HexBinary();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileDownload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org", name = "fileDownload")
    public JAXBElement<FileDownload> createFileDownload(FileDownload value) {
        return new JAXBElement<FileDownload>(_FileDownload_QNAME, FileDownload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileDownloadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org", name = "fileDownloadResponse")
    public JAXBElement<FileDownloadResponse> createFileDownloadResponse(FileDownloadResponse value) {
        return new JAXBElement<FileDownloadResponse>(_FileDownloadResponse_QNAME, FileDownloadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileUploadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org", name = "fileUploadResponse")
    public JAXBElement<FileUploadResponse> createFileUploadResponse(FileUploadResponse value) {
        return new JAXBElement<FileUploadResponse>(_FileUploadResponse_QNAME, FileUploadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileUpload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.org", name = "fileUpload")
    public JAXBElement<FileUpload> createFileUpload(FileUpload value) {
        return new JAXBElement<FileUpload>(_FileUpload_QNAME, FileUpload.class, null, value);
    }

}
