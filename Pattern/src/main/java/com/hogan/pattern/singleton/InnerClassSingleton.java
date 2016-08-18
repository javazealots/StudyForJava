package com.hogan.pattern.singleton;

import java.io.Serializable;

/**
 * 
 * @author Hogan
 * @description 静态内部类式
 * @Date Aug 18, 2016 3:37:12 PM
 */
public class InnerClassSingleton implements Singleton ,Serializable{

	private InnerClassSingleton() {
	}

	public static InnerClassSingleton newInstance() {
		return InnerSingleton.instance;
	}

	/**
	 * 使用时才会加载内部类，是线程安全的
	 */
	private static class InnerSingleton {
		private static final InnerClassSingleton instance = new InnerClassSingleton();
	}
}
