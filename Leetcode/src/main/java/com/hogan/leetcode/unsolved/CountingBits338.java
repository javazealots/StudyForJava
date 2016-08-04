package com.hogan.leetcode.unsolved;

/**
 * 
 * @author Hogan
 * @question Given a non negative integer number num. For every numbers i in the
 *           range 0 ≤ i ≤ num calculate the number of 1's in their binary
 *           representation and return them as an array
 * @case For num = 5 you should return [0,1,1,2,1,2]
 * @Date Aug 4, 2016 11:43:52 PM
 * @finishDate
 */
public class CountingBits338 {

	public int[] countBits(int num) {
		int[] temp = new int[num];
		for (int i = 0; i < num; i++) {
			
		}
		return temp;
	}

	public static void main(String[] args) {
		int i = 0;
		while ((100 >> i) != 0) {
			System.out.println((100 >> i) & 1);
			i++;
		}
	}

}
