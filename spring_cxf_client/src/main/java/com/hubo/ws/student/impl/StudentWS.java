
package com.hubo.ws.student.impl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.hubo.ws.student.ObjectFactory;
import com.hubo.ws.student.Student;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "StudentWS", targetNamespace = "http://student.ws.hubo.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentWS {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "saveStudent", targetNamespace = "http://student.ws.hubo.com/", className = "com.hubo.ws.student.SaveStudent")
    @ResponseWrapper(localName = "saveStudentResponse", targetNamespace = "http://student.ws.hubo.com/", className = "com.hubo.ws.student.SaveStudentResponse")
    public void saveStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        Student arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.hubo.ws.student.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getById", targetNamespace = "http://student.ws.hubo.com/", className = "com.hubo.ws.student.GetById")
    @ResponseWrapper(localName = "getByIdResponse", targetNamespace = "http://student.ws.hubo.com/", className = "com.hubo.ws.student.GetByIdResponse")
    public Student getById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns com.hubo.ws.student.GetNoResponse.Return
     */
    @WebMethod
    @WebResult(name = "_return", targetNamespace = "")
    @RequestWrapper(localName = "getNo", targetNamespace = "http://student.ws.hubo.com/", className = "com.hubo.ws.student.GetNo")
    @ResponseWrapper(localName = "getNoResponse", targetNamespace = "http://student.ws.hubo.com/", className = "com.hubo.ws.student.GetNoResponse")
    public com.hubo.ws.student.GetNoResponse.Return getNo();

    /**
     * 
     * @return
     *     returns java.util.List<com.hubo.ws.student.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://student.ws.hubo.com/", className = "com.hubo.ws.student.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://student.ws.hubo.com/", className = "com.hubo.ws.student.FindAllResponse")
    public List<Student> findAll();

}
