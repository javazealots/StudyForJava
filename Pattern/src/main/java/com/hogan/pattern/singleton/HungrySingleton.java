package com.hogan.pattern.singleton;

import java.io.Serializable;

/**
 * 
 * @author Hogan
 * @description 饿汉式 这种方式有一个问题就是，不过不适用该类，会造成资源的浪费。因为不论是不是用该类，都会创建一个对象。
 * @Date Aug 18, 2016 11:48:37 AM
 */
public class HungrySingleton implements Singleton,Serializable {

	/**
	 * 这一步是通过类加载器去执行的，所以当加载类的时候就会创建该对象，所以不存在并发的问题。 关于类加载的过程，请看之后的讲述。
	 */
	private static HungrySingleton hungrySingleton = new HungrySingleton();

	private HungrySingleton() {
	}

	/**
	 * 因为这是返回的类加载时已经创建的对象，所以不逊在线程同步的问题，所以不需要加synchronized来处理并发的问题。
	 * 
	 * @return
	 */
	public static HungrySingleton newInstance() {
		return hungrySingleton;
	}
}
