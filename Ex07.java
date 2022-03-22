/*
1. 1~10까지 홀수들 출력.
2. 1+3+5+7+9=000 출력.
3. 1~50까지 4의 배수 출력.
4. a~z까지 출력 ex) a,b,c,d,e, ...,z
5. 구구단 출력.
*/

class Ex07{
	public static void main(String[] args){
		
		//1. 1~10까지 홀수들 출력.
		for(int i=1; i<11; i++){
			if(i%2 != 0){
				System.out.println(i);
			}
		}
		System.out.println("------------------------------------\n");
		
		//2. 1+3+5+7+9=000 출력.1
		int total = 0;
		Boolean isFirst = true;
		for(int i = 1; i <= 10; i++){
			if(i%2 != 0){
				if(isFirst == false){
					System.out.print("+");
				}else{
					isFirst = false;
				}
				System.out.print(i);
				
				total += i;
			}
		}
		System.out.println("=" + total);
		System.out.println("------------------------------------\n");
			
		//3. 1~50까지 4의 배수 출력.
		for(int j=1; j<51; j++){
			if(j%4 ==0){
				System.out.println(j);
			}
		}
		System.out.println("------------------------------------\n");
		
		//4. a~z까지 출력 ex) a,b,c,d,e, ...,z
		for(char a = 'a'; a<'z'; a++){
			System.out.print(a);
		}
		System.out.println("\n------------------------------------\n");
		
		//5. 구구단 출력.
		for(int k = 1; k < 10; k++){
			for(int n = 2; n < 10; n++){
				int result = k*n;
				System.out.print(n + "x" + k + "=" + result);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		/*
		   xx8xx
		   x888x
		   88888
		   x888x
		   xx8xx
		
		*/
		int n = 3;
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= n; j++){
				System.out.print("");
			}
			System.out.print("\n");
		}
		
	}
}