
package com.hubo.ws.hello.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "HelloWSImplService", targetNamespace = "http://impl.hello.ws.hubo.com/", wsdlLocation = "http://192.168.1.23/services/helloWs?wsdl")
public class HelloWSImplService
    extends Service
{

    private final static URL HELLOWSIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.hubo.ws.hello.impl.HelloWSImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.hubo.ws.hello.impl.HelloWSImplService.class.getResource(".");
            url = new URL(baseUrl, "http://192.168.1.23/services/helloWs?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://192.168.1.23/services/helloWs?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        HELLOWSIMPLSERVICE_WSDL_LOCATION = url;
    }

    public HelloWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWSImplService() {
        super(HELLOWSIMPLSERVICE_WSDL_LOCATION, new QName("http://impl.hello.ws.hubo.com/", "HelloWSImplService"));
    }

    /**
     * 
     * @return
     *     returns HelloWSImpl
     */
    @WebEndpoint(name = "HelloWSImplPort")
    public HelloWSImpl getHelloWSImplPort() {
        return super.getPort(new QName("http://impl.hello.ws.hubo.com/", "HelloWSImplPort"), HelloWSImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWSImpl
     */
    @WebEndpoint(name = "HelloWSImplPort")
    public HelloWSImpl getHelloWSImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.hello.ws.hubo.com/", "HelloWSImplPort"), HelloWSImpl.class, features);
    }

}
