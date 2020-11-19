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
     * @param txt - String for check
     * @return - true if String is polindrom
     * @throws com.mycompany.MyException - if string is empty
     */
    @WebMethod(operationName = "splitRevert")
    public Boolean splitRevert(@WebParam(name = "name") String txt) throws MyException {
        if (null == txt || "".equals(txt.trim())) {
            throw new MyException("Пустая строка");
        }
        boolean result = service.checkForPalindrom(txt);
        StringReverseMessage m = new StringReverseMessage(txt, !result);
        String sendString = new messageDTO(m.getString(), m.getNotPolindrom()).toString();
        service.sendMessage(sendString);
        return !result;
    }
}
