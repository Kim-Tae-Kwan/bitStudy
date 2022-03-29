package com.bit.day10;

class Box2 <A, B>{
	A su1;
	B su2;
	public A getSu1() {
		return su1;
	}
	public void setSu1(A su1) {
		this.su1 = su1;
	}
	public B getSu2() {
		return su2;
	}
	public void setSu2(B su2) {
		this.su2 = su2;
	}
}

public class Ex10 {

	public static void main(String[] args) {
		Box2<Pencil, BallPen> box = new Box2<>();
		box.setSu1(new Pencil());
		box.setSu2(new BallPen());
		
		Pencil pen1 = box.getSu1();
		BallPen pen2 = box.getSu2();
		pen1.draw();
		pen2.draw();
	}

}
