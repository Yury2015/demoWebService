package com.mycompany;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
public class ServiceTest {

    public ServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of reverseString method, of class Service.
     */
    @Test
    public void testReverseString() throws Exception {
        // set up
        System.out.println("reverseString");
        String source = "TestString";
        Service service = new Service();
        String expected = "gnirtStseT";

        // execute && verify
        assertEquals(expected, service.reverseString(source));

        // tearDown
    }

    @Test
    public void createMessage() {
        // set up
        System.out.println("createMessage");
        StringReverseMessage message = new StringReverseMessage("test", true);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<message>\n    <request>test</request>\n    <response>true</response>\n</message>";

        // execut & verify
        assertEquals(expected, message.toStringXML());

        // tearDown
    }

    @Test
    public void testShouldMarshallMessage() throws JAXBException {

        // set up
        System.out.println("testShouldMarshallMessage");
        StringReverseMessage message = new StringReverseMessage("test", true);
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(StringReverseMessage.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // execute
        m.marshal(message, writer);
        System.out.println(writer);

        // verify
        assertEquals(message.toStringXML(), writer.toString().trim());
        
        // tear Down
        message = null;
        writer = null;
        context = null;
        m = null;

    }

    @Test
    public void testShouldUnmarshallMessage() throws JAXBException {
        // setup
        System.out.println("testShouldUnmarshallMessage");
        StringReader reader = new StringReader(new StringReverseMessage("test", true).toStringXML());
        JAXBContext context = JAXBContext.newInstance(StringReverseMessage.class);
        Unmarshaller u = context.createUnmarshaller();
        
        // execute
        StringReverseMessage message = (StringReverseMessage) u.unmarshal(reader);

        // verify
        assertEquals("test", message.getString());
        assertEquals(true, message.getNotPolindrom());
        
        // tear Down
        u = null;
        reader = null;
        context = null;
        message = null;
        
    }

}
