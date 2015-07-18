/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
@WebService(serviceName = "demoWebService")
@Stateless()
public class DemoWebService {

    @EJB
    private Service service;
    
    
    /**
     * This is a sample web Service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "splitRevert")
    public String splitRevert(@WebParam(name = "name") String txt) {
        String result = service.reverseString(txt);
        StringReverseMessage m = new StringReverseMessage(txt, result);
        String send = new messageDTO(m.getString(), m.getReverseString()).toString();
        return result;
    }
}
