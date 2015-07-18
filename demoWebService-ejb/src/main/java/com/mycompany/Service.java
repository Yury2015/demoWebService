package com.mycompany;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
@Stateless
public class Service {

    @EJB
    ProducerEJB message;
    
    

    public Service() {
    }

    public String reverseString(String source) {
        int i;
        int len = source.length();
        StringBuilder result = new StringBuilder(len);

        for (i = (len - 1); i > -1; i--) {
            result.append(source.charAt(i));
        }
        String dto = new messageDTO(source, result.toString()).toString();
        sendMessage(dto);
        return new String(result);
    }

    public void sendMessage(String send) {
        message.sendMessage(send);
    }
}
