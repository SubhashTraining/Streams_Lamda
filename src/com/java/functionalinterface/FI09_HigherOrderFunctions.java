package com.java.functionalinterface;

import java.util.List;
import java.util.function.Predicate;

/*
 	Higer order functions are functions that returns a function
 */

public class FI09_HigherOrderFunctions {

	static List<String> course ;
	public static void main(String args[]) {
		
		 course = List.of("Java","Spring Boot","AWS","Delta Corp","DD","GDS","Algorithm");
		
		 Predicate<String> predicate_lenth4 = getPredicate(4);
		 Predicate<String> predicate_length7 = getPredicate(7);
		 
		 System.out.println(
				 
				 course.stream().filter(predicate_lenth4).toList()
				 );
		 
		 System.out.println(
				 course.stream().filter(predicate_length7).toList()
				 );
		 
		
		
	}
	
	private static Predicate<String> getPredicate(int length){
		
		return course-> course.length()>=length;
		
	}
}
