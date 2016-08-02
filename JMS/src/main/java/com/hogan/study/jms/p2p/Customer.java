package com.hogan.study.jms.p2p;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

public class Customer extends BaseJMS {

	private static final String DEFAULT_QUEUE_NAME = "JMX_TEST";
	private MessageConsumer consumer;

	public Customer() {
		try {
			destination = session.createQueue(DEFAULT_QUEUE_NAME);
			consumer = session.createConsumer(destination);
			for (;;) {
				TextMessage message = (TextMessage) consumer.receive();
				if (message != null) {
					System.out.println(message.getText());
				} else {
					break;
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
