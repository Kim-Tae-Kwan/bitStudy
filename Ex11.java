class Ex11{
	public static void main(String[] args){
		System.out.println("호출전");
		int result = func01();
		func02(21321321, 123456);
		System.out.println("호출후:" + result);
	}
	
	public static int func01(){
		System.out.println("func01 run...");
		return 123;
	}
	
	public static void func02(int a){
		System.out.println("전달 받은 매개변수: " + a);
	}
	public static void func02(int a, int b){
		System.out.println("전달 받은 매개변수: " + a + "," + b);
	}
}