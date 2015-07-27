package com.mycompany;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author Юрий Кузнецов <kuznetsov_yura@mail.ru>
 */
@Stateless
public class ProducerEJB {

    @Resource(lookup = "jms/javaee7/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/javaee7/Queue")
    private Queue queue;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public ProducerEJB() {
    }

    public void sendMessage(String m) {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, m);
        }
    }

}
