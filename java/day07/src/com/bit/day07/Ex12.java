package com.bit.day07;

class BitException extends Exception{
	public BitException() {
		super("0을 나눠서 에러발생");
	}
}

public class Ex12 {

	public static void main(String[] args) {
		int a, b ,c;
		a = 0;
		b = 1;
		c = 0;
		
		try {
			c = func(a, b);
		}catch(BitException e) {
			e.printStackTrace();
		}
		
		System.out.println(a + "÷" + b + "=" + c);
	}
	
	public static int func(int a, int b) throws BitException{
		if(a == 0) {
			BitException ex = new BitException();
			throw ex;
		}
		return a / b;
	}
}
