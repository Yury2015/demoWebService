package com.mycompany;


import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
@WebService(serviceName = "demoWebService")
@Stateless()
public class DemoWebService {

    private static final Logger log = Logger.getLogger(DemoWebService.class);
    @EJB
    private Service service;
    
    
    /**
     * This is a sample web Service operation
     * @param txt
     * @return 
     * @throws com.mycompany.MyException 
     */
    @WebMethod(operationName = "splitRevert")
    public Boolean splitRevert(@WebParam(name = "name") String txt) throws MyException {
        if (null == txt || "".equals(txt.trim())) {
            log.error("Empty string in parameter name");
            throw new MyException("Пустая строка");
        }
        Boolean result = service.checkForPalindrom(txt);
        StringReverseMessage m = new StringReverseMessage(txt, !result);
        String sendString = new messageDTO(m.getString(), m.getNotPolindrom()).toString();
        service.sendMessage(sendString);
        return !result;
    }
}
