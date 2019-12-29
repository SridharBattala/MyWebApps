package com.sree.leave.programs.datastructures.arrays;

import java.util.Arrays;

class Rearrange 
{ 
	/**
	 * Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space
	 * @param arr
	 * @param n
	 */
	static void rearrange(int arr[], int n) 
	{ 
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i]+(arr[arr[i]] % n)*n;

		}

		for (int i = 0; i < n; i++) {
			arr[i] =arr[i]/ n; 

		}
		System.out.println(Arrays.toString(arr));
	} 

	
	/* Driver program to test above functions */
	public static void main(String[] args) 
	{ 
		
		int arr[] = {3, 2, 0, 1}; 
		

		System.out.println("Given Array is :"); 
		rearrange(arr, arr.length); 

		
	} 
} 



