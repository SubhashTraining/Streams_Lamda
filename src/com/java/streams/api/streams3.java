package com.java.streams.api;

import java.util.List;

//Find the max number in the list
public class streams3 {
	
	
	public static void main(String args[]) {
		
		List<Integer> list = List.of(55,85,74,665,214,525,25);
		
		System.out.println(list.stream()
				.reduce(0, streams3::greatest ));
		
		System.out.println(list.stream().reduce(0,(n1,n2)-> (n1>n2?n1:n2)));
		
		//What if the the numbers are less than 0 , the max no can stillbe less than zero
		// and this will always return 0
		
		System.out.println(list.stream().reduce(Integer.MIN_VALUE,(n1,n2)-> (n1>n2?n1:n2)));
		
		// return the  min number
		System.out.println(list.stream().reduce(Integer.MAX_VALUE,(n1,n2)-> (n1>n2?n2:n1)));
	}

	static int greatest(int aggregate, int nextno) {
		if(aggregate>= nextno) {
			return aggregate;
		}
		else
			return nextno;
	}
}
