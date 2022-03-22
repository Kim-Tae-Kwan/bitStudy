package com.bit.day05;

public class Ex14 {

	public static void main(String[] args) {
		int[] arr1;
		arr1 = new int[] {1,2,3,4};
		
		int[] arr2 = new int[] {5,6,7};
		int[] arr3 = new int[] {8,9};
		
		int[][] arr4 = new int[][] {arr1,arr2,arr3};
		
		for(int i = 0; i < arr4.length ; i++) {
			for(int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
