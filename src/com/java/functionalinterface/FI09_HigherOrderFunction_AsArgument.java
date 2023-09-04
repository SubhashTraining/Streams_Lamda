package com.java.functionalinterface;

import java.util.List;
import java.util.function.Function;

public class FI09_HigherOrderFunction_AsArgument {
	
	
	
	public static void main(String args[]) {
		
		
		List<Integer> nos = List.of(344,34,346,655,65,646,343,34);
		
		
		List<Integer> squareNos = getListFromFunction(nos,n->n*n)	;	
		List<Integer> cubes = getListFromFunction(nos,n->n*n*n)	;
		
		System.out.println(squareNos+"\n"+ cubes);
		
		
	}
	
 
	private static List<Integer> getListFromFunction(List<Integer> nos,Function<Integer,Integer> function){
		
		return nos.stream().map(function).toList();
		
	}
}
