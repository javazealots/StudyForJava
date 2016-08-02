package com.hogan.study.jms.p2p;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Producer extends BaseJMS {

	private static final String DEFAULT_QUEUE_NAME = "JMX_TEST";
	private MessageProducer producer;

	public Producer() {
		try {
			destination = session.createQueue(DEFAULT_QUEUE_NAME);
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			sendMessage(session, producer);
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
			closeConnection();
		}
	}

	public void sendMessage(Session session, MessageProducer producer) {
		for (int i = 0; i < 10; i++) {
			try {
				TextMessage message=session.createTextMessage("Producer message "+i);
				System.out.println("Send message: Producer message "+i);
				producer.send(message);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
