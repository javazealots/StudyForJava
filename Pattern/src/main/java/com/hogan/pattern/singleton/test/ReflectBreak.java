package com.hogan.pattern.singleton.test;

import java.lang.reflect.Constructor;

import org.junit.Test;

import com.hogan.pattern.singleton.HungrySingleton;

/**
 * 
 * @author Hogan
 * @description 通过反射破解，从而创建多个实例(其实就是调用单例的私有构造器创建对象) 饿汉式/懒汉式/双重检测锁/静态内部类
 *              都可以通过此种方式破解
 * @Date Aug 18, 2016 4:35:34 PM
 */
public class ReflectBreak {

	private static final String SINGLETON_HUNGRY = "com.hogan.pattern.singleton.HungrySingleton";
	private static final String SINGLETON_LAZY = "com.hogan.pattern.singleton.LazySingleton";
	private static final String SINGLETON_DOUBLE_LOCK = "com.hogan.pattern.singleton.DoubleLockSingleton";
	private static final String SINGLETON_INNER_CLASS = "com.hogan.pattern.singleton.EnumSingleton";

	@Test
	public void test() {
		try {
			Class<HungrySingleton> clasz = (Class<HungrySingleton>) Class.forName(SINGLETON_HUNGRY);
			Constructor<HungrySingleton> constructor = clasz.getDeclaredConstructor(null);
			constructor.setAccessible(true);
			HungrySingleton instance1 = constructor.newInstance();
			HungrySingleton instance2 = constructor.newInstance();
			System.out.println(instance1.hashCode());
			System.out.println(instance2.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
