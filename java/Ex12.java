class Ex12{

/*
메소드 종류
1. static method - 클래스메소드
2. non-static method - 멤버메소드

static -> static 			[클래스명].메소드명()
static -> non-static 		참조변수.메서드명()
non-static -> static		[클래스명].메소드명()
non-static -> non-static	메소드명()

*/	

	public static void main(String[] args){
		Ex12 me = new Ex12();
		me.func1();
		func2();
	}	
	
	public void func1(){
		System.out.println("non-static method func1 run ...");
	}
	
	public static void func2(){
		System.out.println("static method func2 run ...");
	}
}