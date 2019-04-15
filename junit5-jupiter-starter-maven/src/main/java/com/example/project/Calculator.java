package com.example.project;

public class Calculator {

	public int add(int a, int b) throws Exception {
		if (willAdditionOverflow(a, b)) {
			return Integer.MAX_VALUE;
		}
		if (willSubtractionOverflow(a, b)) {
			return Integer.MIN_VALUE;
		}
		return a + b;
	}

	/**
	 * Kiểm tra kết quả cộng số dương có lớn hơn limit ko
	 * @param a số a
	 * @param b số b
	 * @return true hoặc false
	 */
	public static boolean willAdditionOverflow(int a, int b) {
		try {
			Math.addExact(a, b);
			return false;
		} catch (ArithmeticException e) {
			return true;
		}
	}

	/**
	 * Kiểm tra kết quả cộng số âm có lớn hơn limit ko
	 * @param a số a
	 * @param b số b
	 * @return true hoặc false
	 */
	public static boolean willSubtractionOverflow(int a, int b) {
		try {
			Math.subtractExact(a, b);
			return false;
		} catch (ArithmeticException e) {
			return true;
		}
	}

}
