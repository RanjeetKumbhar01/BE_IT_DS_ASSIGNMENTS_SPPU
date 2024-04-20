
package com.myservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MycalculatorWebService", targetNamespace = "http://myservice.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MycalculatorWebService {


    /**
     * 
     * @param num1
     * @param num2
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addition", targetNamespace = "http://myservice.com/", className = "com.myservice.Addition")
    @ResponseWrapper(localName = "additionResponse", targetNamespace = "http://myservice.com/", className = "com.myservice.AdditionResponse")
    @Action(input = "http://myservice.com/MycalculatorWebService/additionRequest", output = "http://myservice.com/MycalculatorWebService/additionResponse")
    public double addition(
        @WebParam(name = "num1", targetNamespace = "")
        double num1,
        @WebParam(name = "num2", targetNamespace = "")
        double num2);

}
