package com.hogan.study.jms.p2p;

import org.junit.Test;

public class TesJmst {

	@Test
	public void testProducer() {
		Producer producer=new Producer();
	}
	
	@Test
	public void testConsumer(){
		//Customer customer=new Customer();
		String s="asdf";
		System.out.println(s.substring(0,2));
		System.out.println(s.substring(0, s.length()-2));
	}
}
