package com.bit.day04;

public class Ex07 {
	public int speed;
	public String name;
		
	public void speedUp() {
		speed +=10;
		System.out.println(name + " 현재 속도는 " + speed + "km");
	}
	
	public void speedDown() {
		speed -=10;
		System.out.println(name + " 현재 속도는 " + speed + "km");
	}
	
	public static void main(String[] args) {
		Ex07 myCar = new Ex07();
		Ex07 myCar2 = new Ex07();
		myCar.name = "first car";
		myCar2.name = "second car";
		System.out.println(myCar.name + " 현재 속도는 " + myCar.speed + "km");
		myCar.speedUp();
		myCar2.speedUp();
		myCar.speedUp();
		myCar2.speedUp();
		myCar.speedUp();
		myCar2.speedUp();
		myCar.speedUp();
		myCar2.speedUp();
		myCar.speedUp();
		myCar2.speedUp();
		myCar.speedDown();
		myCar2.speedDown();
		myCar.speedDown();
		myCar2.speedDown();
		myCar.speedDown();
		myCar2.speedDown();
		myCar.speedDown();
		myCar2.speedDown();
		myCar.speedDown();
		myCar2.speedDown();
	}

}
