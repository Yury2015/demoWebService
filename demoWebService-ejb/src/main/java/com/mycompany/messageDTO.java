/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Serializable;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
public class messageDTO implements Serializable {

    private String string;
    private String reverseString;

    public messageDTO() {
    }

    public messageDTO(String string, String reverseString) {
        this.string = string;
        this.reverseString = reverseString;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getReverseString() {
        return reverseString;
    }

    public void setReverseString(String reverseString) {
        this.reverseString = reverseString;
    }

    @Override
    public String toString() {
        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<message>\n"
                + "    <request>" + string + "</request>\n"
                + "    <response>" + reverseString + "</response>\n"
                + "</message>";
        return String.valueOf(result);
    }

}
