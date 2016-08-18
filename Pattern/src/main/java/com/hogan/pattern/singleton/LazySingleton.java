package com.hogan.pattern.singleton;

import java.io.Serializable;

/**
 * 
 * @author Hogan
 * @description 懒汉式 当真正使用时才创建实例，即可以实现懒加载
 * @Date Aug 18, 2016 2:59:52 PM
 */
public class LazySingleton implements Singleton,Serializable {

	private static LazySingleton lazySingleton;

	private LazySingleton() {
	}

	/**
	 * 为了避免并发情况下创建多个实例，在这里加上了synchronized关键字来处理多线程的问题。但是这样也就造成了效率很低。
	 * 
	 * @return
	 */
	public static synchronized LazySingleton newInstance() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
}
