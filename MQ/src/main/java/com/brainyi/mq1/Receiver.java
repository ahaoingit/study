package com.brainyi.mq1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * TODO
 *
 * @author ahao 2020-11-30
 */
public class Receiver {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("queue");
        MessageConsumer consumer = session.createConsumer(queue);
        while (true) {
            TextMessage message =(TextMessage) consumer.receive();
            System.out.println(message.getText());
        }
    }
}
