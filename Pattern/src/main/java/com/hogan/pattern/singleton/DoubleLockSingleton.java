package com.hogan.pattern.singleton;

import java.io.Serializable;

/**
 * 
 * @author Hogan
 * @description 双重检测锁式(其实就是懒汉式的加强版)
 * @Date Aug 18, 2016 3:21:49 PM
 */
public class DoubleLockSingleton implements Singleton,Serializable {

	private static DoubleLockSingleton doubleLockSingleton;

	private DoubleLockSingleton() {
	}

	public static DoubleLockSingleton newInstance() {
		if (doubleLockSingleton == null) {
			synchronized (DoubleLockSingleton.class) {
				if (doubleLockSingleton == null) {
					doubleLockSingleton = new DoubleLockSingleton();
				}
			}
		}
		return doubleLockSingleton;
	}
}
