package com.hogan.pattern.singleton;

/**
 * 
 * @author Hogan
 * @description 枚举单例 由于是基于JVM实现的，所以不能通过反射或者反序列化破解
 * @Date Aug 18, 2016 4:26:24 PM
 */
public enum EnumSingleton implements Singleton{

	INSTANCE;
}
