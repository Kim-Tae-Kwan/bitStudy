package com.bit.day06;

//

interface Inter01{
	public final static int su1 = 1111; //기본 형식
	final static int su2 = 2222;
	static int su3 = 3333;
	int su4 = 4444; //public, final, static 생략.
	
	public abstract void func01(); //기본 형식
	public void func02();
	void func03(); //public, abstract 생략. 
}

interface Inter02 extends Inter01, Inter03{}
interface Inter03 {}

public class Ex14 extends Object implements Inter02{
	
	public static void main(String[] args) {
		System.out.println(Inter01.su4);
		Inter01 me = new Ex14();
	}
	
	@Override
	public void func01() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void func02() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void func03() {
		// TODO Auto-generated method stub
		
	}
}
