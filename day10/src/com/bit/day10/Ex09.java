package com.bit.day10;

class Pen{
	void draw() {
		System.out.println("선을 긋는다.");
	}
}

class Pencil extends Pen{
	@Override
	void draw() {
		System.out.println("지워질 수 있는 선을 긋는다.");
	}
}

class BallPen extends Pen{
	@Override
	void draw() {
		System.out.println("안지워지는 선을 긋는다.");
	}
}

// Type, Key, Value, Element
class Box<T>{
	T su;
	
	public void setSu(T su) {
		this.su = su;
	}

	public T getSu() {
		return su;
	}
}

public class Ex09 {
	
	public static void main(String[] args) {
		Box<Pen> box = new Box<>();
		BallPen myPen = new BallPen();
		Pencil myPen2 = new Pencil();
		box.setSu(myPen);
	
		
		Pen obj = box.getSu();
		obj.draw();
	}

}
