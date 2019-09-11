package com.sree.leave.programs.algorithms.backtracking;

import java.util.Vector;
/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * @author sridharbattala
 *
 */
public class CoinChangeProblem { 

	//The vector v stores current subset. 
	static void printAllSubsetsRec(int arr[], int n, Vector<Integer> v, 
							int sum,int matchingSum) 
	{ 
		System.out.println("arr="+arr.toString()+", n="+n+", v="+v.toString()+", sum="+sum);
		// If remaining sum is 0, then print all 
		// elements of current subset. 
		if (sum == matchingSum) { 
			for (int i=0;i<v.size();i++) 
				System.out.print( v.get(i) + " "); 
			System.out.println(); 
			return; 
		} 

		// If no remaining elements, 
		if (n == arr.length || sum > matchingSum) 
			return; 

		// We consider two cases for every element. 
		// a) We do not include last element. 
		// b) We include last element in current subset. 
		Vector<Integer> v1=new Vector<Integer>(v); 
		v1.add(arr[n]);
		printAllSubsetsRec(arr, n , v1, sum+arr[n],matchingSum); 
		printAllSubsetsRec(arr, n+1 , v, sum,matchingSum); 

	} 



	//Driver code 
	public static void main(String args[]) 
	{ 
		int arr[] = { 1,2 }; 
		int matchingSum = 3; 
		Vector<Integer> v= new Vector<Integer>(); 
		printAllSubsetsRec(arr, 0, v, 0,matchingSum); 
		
	} 
}
