package com.hogan.pattern.singleton.test;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.hogan.pattern.singleton.HungrySingleton;
import com.hogan.pattern.singleton.LazySingleton;

/**
 * 
 * @author Hogan
 * @description 效率测试
 * @Date Aug 18, 2016 3:05:55 PM
 */
public class EffectiveTest {

	private int threadCount = 10000000;

	public long testHungrySingleton() throws Exception {
		final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		long startTime = System.currentTimeMillis();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < threadCount; i++) {
					HungrySingleton.newInstance();
					countDownLatch.countDown();
				}
			}
		}).start();
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public long testLazySingleton() throws Exception {
		final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		long startTime = System.currentTimeMillis();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < threadCount; i++) {
					LazySingleton.newInstance();
					countDownLatch.countDown();
				}
			}
		}).start();
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	/**
	 * 通过创建大量的实例测试各个单例实现的效率
	 */
	@Test
	public void testEffective() {
		try {
			System.out.println(testHungrySingleton());
			System.out.println(testLazySingleton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
