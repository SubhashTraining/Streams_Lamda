package com.java.streams.api;


import java.util.*;
public class streams2 {

	public static void main(String args[]) {
	
		System.out.println(List.of(55,45,457,64,47,7).stream()
		.reduce(0,streams2::sum));
		
		// Reduce is used to reduce the steam of input to a single value
		// argumnt 1 is the initial value called the indentity value and the next arg is the function
		// to reduce the stream to a single value
		
		//Reduction of the stream (aggregate and next input). Aggregation opertaion
		
	
	System.out.println(List.of(55,45,457,64,47,7).stream()
			.reduce(0,streams2::sum1));
			
	System.out.println(List.of(55,45,457,64,47,7).stream()
			.reduce(0,(n1,n2)-> n1+n2));
	
	System.out.println(List.of(55,45,457,64,47,7).stream()
			.reduce(0,(n1,n2)-> n1+n2));

	
	System.out.println(List.of(55,45,457,64,47,7).stream()
			.reduce(0,Integer::sum));
	
}
	
	static int sum(int n1, int n2) {
		return n1+n2;
	}
	
	static int sum1(int n1, int n2) {
		System.out.println(n1+" "+n2);
		return n1+n2;
	}
}
