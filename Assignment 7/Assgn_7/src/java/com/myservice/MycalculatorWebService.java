/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Kumbh
 */
@WebService(serviceName = "MycalculatorWebService")
public class MycalculatorWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addition")
    public double addition(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1+num2;
    }

    /**
     * This is a sample web service operation
     */
    
}
