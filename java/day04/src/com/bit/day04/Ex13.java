package com.bit.day04;

class Car{
	public final String model;
	public String company;
	public int speed;
	public int max;
	public String color;
	
	public Car(int max) {
		if(max <= 150) {
			model = "모닝";
		}else if(max <= 180) {
			model = "k3";
		}else if(max <= 200) {
			model = "k5";
		}else {
			model = "몰라";
		}
	}
	
	public Car(String model, int max) {
		this.color = "흰색";
		this.model = model;
		this.max = max;
	}
	
	public void speedUp() {
//		speed += 10;
//		if(speed >150) speed = 150;
		if(speed + 10 > max) speed = max;
		else speed += 10;
	}
	
	public void speedDown() {
//		speed -= 15;
//		if(speed < 0) speed = 0;
		if(speed - 15 < 0) speed = 0;
		else speed -= 15;
	}
	
	public void showSpeed() {
		System.out.println(color + " " + model + " 내차의 현재속도는 " + speed + "km");
	}
}

public class Ex13 {

	public static void main(String[] args) {
		Car myCar = new Car(190);
	    myCar.showSpeed();
	    
	    for(int i=0; i<20; i++) {
	       myCar.speedUp();
	       myCar.showSpeed();
	    }
	      
	    for(int i=0; i<20; i++) {
	       myCar.speedDown();
	       myCar.showSpeed();
	    }
	    
	    myCar = new Car("k3", 180);
	    myCar.color = "쥐색";
	    myCar.showSpeed();
	    
	    for(int i=0; i<20; i++) {
	       myCar.speedUp();
	       myCar.showSpeed();
	    }
	      
	    for(int i=0; i<20; i++) {
	       myCar.speedDown();
	       myCar.showSpeed();
	    }
	}

}
