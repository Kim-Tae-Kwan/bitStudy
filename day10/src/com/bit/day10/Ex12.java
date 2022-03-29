package com.bit.day10;

class Lec12{
	// ? -> 나중에 타입 결정.
	public Box<? super BallPen> func() {
		return new Box<>();
	}
}

public class Ex12 extends Lec12{
	
	@Override
	public Box<Pen> func() {
		return new Box<>();
	}

	public static void main(String[] args) {
		Box<Pen> box = new Box();
		Box box2 = new Box<Pen>();
		
		Box<Pen> box3 = new Box<>(); //jdk 버전 제약 1.7 ~

		Box<?> box4 = new Box<>();
	}

}
