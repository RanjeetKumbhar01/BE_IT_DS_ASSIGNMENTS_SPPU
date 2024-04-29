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
@WebService(serviceName = "mycalcualtor")
public class mycalcualtor {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "palindrome")
    public double palindrome(@WebParam(name = "n") double n) {
        //TODO write your implementation code here:
        double reversed_n = 0;
        while (n > 0) {
            reversed_n = reversed_n * 10 + n % 10;
            n = n / 10;
        }
        return reversed_n;
        }
    }

    /**
     * This is a sample web service operation
     */
    
}
