package com.bit.Thread2;

//Thread 우선순위
class Lec01 extends Thread{
	int cnt;
	boolean isStop = false;
	
	public Lec01(String name, int cnt) {
		super.setName(name);
		this.cnt = cnt;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < cnt; i++) {
			if(isStop == true) i--;
			System.out.println(this.getName());
		}
	}
}

public class Ex01 {

	public static void main(String[] args) {
		// 스레드의 활동 빈도 확률 -> 1:1:1
		Lec01 thr1 = new Lec01("첫번째",2);
		Lec01 thr2 = new Lec01("두번째",4);
		Lec01 thr3 = new Lec01("세번째",6);
		
		//확률이 높다고 빨리 끝나지 않는다.
		thr1.setPriority(Thread.MIN_PRIORITY); // 스레드의 빈도(1~10) : default = 5
		thr2.setPriority(Thread.NORM_PRIORITY); // 최저 확률
		thr3.setPriority(Thread.MAX_PRIORITY);// 최고 확률
		
		thr1.start();
		thr2.start();
		thr3.start();
		
	}

}
