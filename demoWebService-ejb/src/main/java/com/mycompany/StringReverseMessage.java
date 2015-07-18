package com.mycompany;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class StringReverseMessage {

    @XmlElement(name = "request")
    private String string;
    @XmlElement(name = "response")
    private String reverseString;

    public StringReverseMessage() {
    }
    
    public StringReverseMessage(String str, String reverseStr) {
        this.string = str;
        this.reverseString = reverseStr;
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

    public String toStringXML() {
        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<message>\n"
                + "    <request>" + string + "</request>\n"
                + "    <response>" + reverseString + "</response>\n"
                + "</message>";
        return String.valueOf(result);
    }

}
