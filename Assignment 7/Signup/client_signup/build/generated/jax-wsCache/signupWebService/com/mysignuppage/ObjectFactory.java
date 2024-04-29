
package com.mysignuppage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mysignuppage package. 
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

    private final static QName _Mysignup_QNAME = new QName("http://mysignuppage.com/", "mysignup");
    private final static QName _MysignupResponse_QNAME = new QName("http://mysignuppage.com/", "mysignupResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mysignuppage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mysignup }
     * 
     */
    public Mysignup createMysignup() {
        return new Mysignup();
    }

    /**
     * Create an instance of {@link MysignupResponse }
     * 
     */
    public MysignupResponse createMysignupResponse() {
        return new MysignupResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mysignup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mysignuppage.com/", name = "mysignup")
    public JAXBElement<Mysignup> createMysignup(Mysignup value) {
        return new JAXBElement<Mysignup>(_Mysignup_QNAME, Mysignup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MysignupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mysignuppage.com/", name = "mysignupResponse")
    public JAXBElement<MysignupResponse> createMysignupResponse(MysignupResponse value) {
        return new JAXBElement<MysignupResponse>(_MysignupResponse_QNAME, MysignupResponse.class, null, value);
    }

}
