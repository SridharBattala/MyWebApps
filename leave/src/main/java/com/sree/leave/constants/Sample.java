package com.sree.leave.constants;

public class Sample {
public static void main(String args[]) {
	letterSort("sridhar");
	   
}
public static String letterSort(String string) {
	  
	   int[] charCount = new int[26]; 
	   for (int i=0; i<string.length(); i++) {
		   charCount[string.charAt(i)-'a']++; 
	   }
	   System.out.println(charCount);
	   for (int i=0;i<26;i++) 
	        for (int j=0;j<charCount[i];j++) 
	             System.out.println((char)('a'+i)); 
	   
  return "";
}
}
