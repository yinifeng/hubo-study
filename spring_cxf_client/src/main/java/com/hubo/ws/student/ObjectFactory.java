
package com.hubo.ws.student;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hubo.ws.student package. 
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

    private final static QName _GetNoResponse_QNAME = new QName("http://student.ws.hubo.com/", "getNoResponse");
    private final static QName _FindAllResponse_QNAME = new QName("http://student.ws.hubo.com/", "findAllResponse");
    private final static QName _GetById_QNAME = new QName("http://student.ws.hubo.com/", "getById");
    private final static QName _GetByIdResponse_QNAME = new QName("http://student.ws.hubo.com/", "getByIdResponse");
    private final static QName _FindAll_QNAME = new QName("http://student.ws.hubo.com/", "findAll");
    private final static QName _SaveStudent_QNAME = new QName("http://student.ws.hubo.com/", "saveStudent");
    private final static QName _GetNo_QNAME = new QName("http://student.ws.hubo.com/", "getNo");
    private final static QName _SaveStudentResponse_QNAME = new QName("http://student.ws.hubo.com/", "saveStudentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hubo.ws.student
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNoResponse.Return }
     * 
     */
    public GetNoResponse.Return createGetNoResponseReturn() {
        return new GetNoResponse.Return();
    }

    /**
     * Create an instance of {@link GetByIdResponse }
     * 
     */
    public GetByIdResponse createGetByIdResponse() {
        return new GetByIdResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link GetNoResponse }
     * 
     */
    public GetNoResponse createGetNoResponse() {
        return new GetNoResponse();
    }

    /**
     * Create an instance of {@link GetById }
     * 
     */
    public GetById createGetById() {
        return new GetById();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link SaveStudentResponse }
     * 
     */
    public SaveStudentResponse createSaveStudentResponse() {
        return new SaveStudentResponse();
    }

    /**
     * Create an instance of {@link SaveStudent }
     * 
     */
    public SaveStudent createSaveStudent() {
        return new SaveStudent();
    }

    /**
     * Create an instance of {@link GetNo }
     * 
     */
    public GetNo createGetNo() {
        return new GetNo();
    }

    /**
     * Create an instance of {@link GetNoResponse.Return.Entry }
     * 
     */
    public GetNoResponse.Return.Entry createGetNoResponseReturnEntry() {
        return new GetNoResponse.Return.Entry();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://student.ws.hubo.com/", name = "getNoResponse")
    public JAXBElement<GetNoResponse> createGetNoResponse(GetNoResponse value) {
        return new JAXBElement<GetNoResponse>(_GetNoResponse_QNAME, GetNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://student.ws.hubo.com/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://student.ws.hubo.com/", name = "getById")
    public JAXBElement<GetById> createGetById(GetById value) {
        return new JAXBElement<GetById>(_GetById_QNAME, GetById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://student.ws.hubo.com/", name = "getByIdResponse")
    public JAXBElement<GetByIdResponse> createGetByIdResponse(GetByIdResponse value) {
        return new JAXBElement<GetByIdResponse>(_GetByIdResponse_QNAME, GetByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://student.ws.hubo.com/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://student.ws.hubo.com/", name = "saveStudent")
    public JAXBElement<SaveStudent> createSaveStudent(SaveStudent value) {
        return new JAXBElement<SaveStudent>(_SaveStudent_QNAME, SaveStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://student.ws.hubo.com/", name = "getNo")
    public JAXBElement<GetNo> createGetNo(GetNo value) {
        return new JAXBElement<GetNo>(_GetNo_QNAME, GetNo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://student.ws.hubo.com/", name = "saveStudentResponse")
    public JAXBElement<SaveStudentResponse> createSaveStudentResponse(SaveStudentResponse value) {
        return new JAXBElement<SaveStudentResponse>(_SaveStudentResponse_QNAME, SaveStudentResponse.class, null, value);
    }

}
