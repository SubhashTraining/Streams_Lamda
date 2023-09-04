package com.java.functionalinterface;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Function;
/*
 	Here we are passing the behavior as an argument not the data
 	We cal this behavioral Parameterization or Functional Parameterization
 */
public class FI03_FunctionalParameterization {
	static List<Integer> list;
	public static void main(String args[]) {
		
		list = List.of(12,455,23,43,544,5644,12,34);
		
		listPrint(n->n%2==0);
		listPrint(n->n%2!=0);
		listPrint(n->n%3==0);
		
		
		listPrint(n->n%2==0, new Function<Integer,Integer>(){

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*t;
			}
			
		});
		
		listPrint(n->n%2==0, n-> n*n*n);
		
	}

	static void listPrint(Predicate<Integer> predicate) {
		
		System.out.println(list.stream().filter(predicate).collect(Collectors.toList()));
	}
	
	static void listPrint(Predicate<Integer> predicate,Function<Integer,Integer> function) {
		
		System.out.println(list.stream().filter(predicate).map(function).collect(Collectors.toList()));
	}
}
