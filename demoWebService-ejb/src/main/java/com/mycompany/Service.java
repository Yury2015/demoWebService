package com.mycompany;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.commons.lang3.StringUtils;

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
        return new String(result);
    }

    public boolean checkForPalindrom(String inputStr) {
        return inputStr.equals(StringUtils.reverse(inputStr));
    }

    //@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)    
    public void sendMessage(String send) {
        message.sendMessage(send);
    }
}
