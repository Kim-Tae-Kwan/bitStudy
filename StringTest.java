class StringTest{
	public static void main(String[] args){
		String val = "asdfas a-sdf";
		
		//1. upper
		System.out.println(val.toUpperCase());
		//2. replace
		System.out.println(val.replaceAll("z", "b"));
		//3. split
		System.out.println(val.split(" ")[0]);
	}
}