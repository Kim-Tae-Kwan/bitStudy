package com.bit.day06;

public class Ex15 implements Cloneable{

	public static void main(String[] args) throws CloneNotSupportedException{
		java.lang.String msg = "abcd";
		java.lang.System.out.println();
		
		Object object = new Object();
		System.out.println(object.hashCode());
		System.out.println(object.toString());
		
		Object object2 = new Object();
		System.out.println(object.equals(object2));
		
		Ex15 me = new Ex15();
		Object obj4 = me.clone();
		Ex15 you = (Ex15)obj4;
		System.out.println(me.hashCode());
		System.out.println(obj4.hashCode());
		System.out.println(you.hashCode());
		
//		System.out.println(me.equals(you));
//		System.out.println(me.hashCode());
//		System.out.println(you.hashCode());
	}

	@Override
	public int hashCode() {
		return 1234;
	}
	
	

}
