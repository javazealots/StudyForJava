package com.hogan.pattern.singleton.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.hogan.pattern.singleton.HungrySingleton;

/**
 * 
 * @author Hogan
 * @description 通过反序列化破解 饿汉式/懒汉式/双重检测锁/静态内部类 都可以通过此种方式破解
 * @Date Aug 18, 2016 7:35:22 PM
 */
public class SerializableBreak {

	@Test
	public void test() {
		HungrySingleton hungrySingleton = HungrySingleton.newInstance();
		System.out.println(hungrySingleton.hashCode());
		try {
			File file = new File("C:/Users/Hogan/Desktop/a.txt");
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(hungrySingleton);
			objectOutputStream.close();
			out.close();

			FileInputStream in = new FileInputStream(file);
			ObjectInputStream inputStream = new ObjectInputStream(in);
			HungrySingleton instance1 = (HungrySingleton) inputStream.readObject();
			System.out.println(instance1.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
