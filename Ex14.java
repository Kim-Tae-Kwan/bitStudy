class Ex14{
	public static void main(String[] args){
		func2();
	}
	
	public static void func2(){
		int a=0;
		while(true){
			System.out.println(a);
			a++;
			if(a==9) break;
		}
	}
	
	//return break continue
	public static void func1(){
		for(int i = 0; i < 10; i++){
			if (i>5) continue;
			System.out.println("i=" + i);
		}
	}
}