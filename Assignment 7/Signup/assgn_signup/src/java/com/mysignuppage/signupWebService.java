/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysignuppage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Kumbh
 */
@WebService(serviceName = "signupWebService")
public class signupWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mysignup")
    public String mysignup(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "phone") String phone, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return name;
    }

    /**
     * This is a sample web service operation
     */
   
}
