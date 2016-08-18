package com.hogan.pattern.singleton.test;

import org.junit.Test;

import com.hogan.pattern.singleton.DoubleLockSingleton;
import com.hogan.pattern.singleton.EnumSingleton;
import com.hogan.pattern.singleton.HungrySingleton;
import com.hogan.pattern.singleton.InnerClassSingleton;
import com.hogan.pattern.singleton.LazySingleton;

/**
 * 
 * @author Hogan
 * @description 测试在多线程条件下，是否只创建一个实例
 * @Date Aug 18, 2016 2:36:51 PM
 */
public class MultiThreadTest {

	private int threadCount = 10000;

	@Test
	public void testHungrySingleton() {
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(HungrySingleton.newInstance().hashCode());
				}
			}).start();
		}
	}
	
	@Test
	public void testLazySingleton() {
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(LazySingleton.newInstance().hashCode());
				}
			}).start();
		}
	}
	
	@Test
	public void testDoubleLockSingleton() {
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(DoubleLockSingleton.newInstance().hashCode());
				}
			}).start();
		}
	}
	
	@Test
	public void testInnerClassSingleton() {
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(InnerClassSingleton.newInstance().hashCode());
				}
			}).start();
		}
	}
	
	@Test
	public void testEnumSingleton() {
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(EnumSingleton.INSTANCE.hashCode());
				}
			}).start();
		}
	}
}
