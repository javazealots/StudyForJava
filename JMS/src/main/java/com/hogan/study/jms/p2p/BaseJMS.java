package com.hogan.study.jms.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public abstract class BaseJMS {

	private String userName = ActiveMQConnection.DEFAULT_USER;
	private String password = ActiveMQConnection.DEFAULT_PASSWORD;
	private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private ConnectionFactory connectionFactory;
	private Connection connection;
	public Session session;
	public Destination destination;
	public MessageProducer producer;

	public BaseJMS() {
		try {
			connectionFactory=new ActiveMQConnectionFactory(userName, password, url);
			connection=connectionFactory.createConnection();
			connection.start();
			session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
