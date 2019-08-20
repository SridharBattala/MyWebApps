package com.sree.leave.programs.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * @author sridharbattala
 *
 */
public class PossiblePermutations {
	
public static void main(String args[]) {
	List<Integer> l1=new LinkedList<>();
	l1.add(1);
	l1.add(2);
	l1.add(3);
	System.out.println(l1);
	for(int i=0;i<l1.size();i++){
		for(int j=0;j<l1.size();j++){
			if(i!=j) {
				//System.out.println(l1);
				int removedEle=l1.remove(i);
				l1.add(j, removedEle);
				System.out.println(l1);
				l1.remove(j);
				l1.add(i,removedEle);
				//System.out.println(l1);
				System.out.println("--------");
			}
		
		}
		}

}
}
