package com.bit.day05;

public class Car {
	private String model;
	private int speed;
	
	public Car(String model) {
		this.model = model;
		this.speed = 0;
	}
	
	public void speedUp() {
		speed += 10;
	}
}
