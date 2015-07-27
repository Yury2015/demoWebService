package com.mycompany;

import javax.xml.ws.WebFault;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
@WebFault(name = "MyException")
public class MyException extends Exception {

    public MyException() {
        super();
    }

    public MyException(String string) {
        super(string);
    }

}
