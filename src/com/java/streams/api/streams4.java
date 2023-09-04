package com.java.streams.api;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public class streams4 {

	public static void main(String args[]) {
		List<Integer> list = List.of(55,85,74,665,214,525,25);
		
		
		//Find the sum of squares of each no
		
		System.out.println( list.stream()
							.map(n-> n*n)
							.reduce((n1,n2)-> n1+n2));
		
		
		
		//Print squares of even nos
		System.out.println("************************");
		list.stream()
		.filter(n-> n%2==0)
		.map(n->n*n)
		.forEach(System.out::println);
		
		System.out.println("Odd nos");
		
		list.stream()
		.filter(n-> n%2!=0)
		.forEach(System.out::println);
		
		
	}
}
