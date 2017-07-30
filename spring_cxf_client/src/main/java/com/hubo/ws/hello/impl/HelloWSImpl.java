
package com.hubo.ws.hello.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "HelloWSImpl", targetNamespace = "http://impl.hello.ws.hubo.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWSImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://impl.hello.ws.hubo.com/", className = "com.hubo.ws.hello.impl.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://impl.hello.ws.hubo.com/", className = "com.hubo.ws.hello.impl.SayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}