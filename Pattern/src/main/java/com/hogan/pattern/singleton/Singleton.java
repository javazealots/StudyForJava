package com.hogan.pattern.singleton;

/**
 * 
 * @author Hogan
 * @Date Aug 18, 2016 11:35:47 AM
 * @description 单例模式
 * 		>> 作用 : 	其作用就是创建对象,不过该对象在app运行周期内只有一份
 * 		>> 实用实例:	1.Windows的任务管理器、回收站就是单例模式的
 * 					2.网站的计数器
 * 					3.数据库的连接池
 * 					4.Servlet中的Application和servlet
 * 		>> 优点:		节约资源，统一管理
 * 		>> 分类:		饿汉式		(线程安全，调用效率高。但是不能够延迟加载)
 * 					懒汉式		(线程安全，调用效率不高。但是可以延时加载)
 * 					双重检测锁式	(由于JVM底层内部模式的原因，会偶尔出现问题)
 * 					静态内部类式	(线程安全，调用效率高，可以延时加载)
 * 					枚举单例		(线程安全，调用效率高，不能延迟加载)
 */	
public interface Singleton {

}
