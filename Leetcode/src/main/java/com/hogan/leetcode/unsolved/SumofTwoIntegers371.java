package com.hogan.leetcode.unsolved;

import org.junit.Test;

/**
 * 
 * @author Hogan
 * @question Calculate the sum of two integers a and b, but you are not allowed
 *           to use the operator + and -.
 * @case Given a = 1 and b = 2, return 3.
 * @Date Aug 5, 2016 1:15:59 PM
 * @finishDate
 */
public class SumofTwoIntegers371 {

	public int getSum(int num1, int num2) {
		int sum = 0, carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);
		return num1;
	}

	@Test
	public void test() {
		System.out.println(getSum(2, 10));
	}
}
