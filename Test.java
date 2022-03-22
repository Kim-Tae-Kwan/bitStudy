class Test{
	public static void main(String[] args){
			
			
		int[] list = new int[]{1,2,3,4,5};
		int temp = 0;
		
		for(int i = 0; i < list.length - 1; i++){
			if(list[i] > list[i+1]){
				temp = list[i];
				list[i] = list[i+1];
				list[i+1] = temp;
			}
					
			
		}
		
		for(int i = 0; i < list.length; i++){
				System.out.println(list[i]);
		}

		Queue
		
		
		
	}
}