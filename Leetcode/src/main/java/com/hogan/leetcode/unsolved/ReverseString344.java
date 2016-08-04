package com.hogan.leetcode.unsolved;

import org.junit.Test;

/**
 * 
 * @author Hogan
 * @question Write a function that takes a string as input and returns the
 *           string reversed.
 * @case Given s = "hello", return "olleh".
 * @Date Aug 4, 2016 11:25:06 PM
 */
public class ReverseString344 {

	/**
	 * This direct alogrithm exceed the limit time.
	 * 
	 * @param str
	 * @return
	 */
	public String reverseString(String str) {
		String temp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			temp += str.charAt(i);
		}
		return temp;
	}

	@Test
	public void test() {
		System.out.println(reverseString("hello"));
	}
}
