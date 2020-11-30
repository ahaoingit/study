package com.brainyi.mq1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * TODO
 *
 * @author ahao 2020-11-30
 */
public class Sender {
    public static void main(String[] args) throws JMSException, InterruptedException {
        //获取连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");
        //获取连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //获取session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地 获取destination
        Topic queue = session.createTopic("queue");
        //向目的地发信息 创建创建者
        MessageProducer producer = session.createProducer(queue);
        for (int i=0 ; i < 99;i++) {
            Message message = session.createTextMessage(i+"");
            producer.send(message);
        }
        //关闭
    }
}
