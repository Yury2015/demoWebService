package com.mycompany;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
@Stateless
public class ProducerEJB {

    // @JMSPasswordCredential(userName="admin", password="S&RhZWL5V28P")
    @Resource(lookup = "jms/javaee7/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/javaee7/Topic")
    private Topic topic;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public ProducerEJB() {
    }

    public void sendMessage(String m) {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(topic, m);
        }
    }

}
