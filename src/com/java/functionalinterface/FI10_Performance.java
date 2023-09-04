package com.java.functionalinterface;

import java.util.List;
import java.util.stream.Stream;


public class FI10_Performance {
	
	public static void main(String args[]) {
		
		
		List<String> course = List.of("Java","Spring Boot","AWS","Delta Corp","DD","GDS","Algorithm");
		
		System.out.println(
				
				course.stream().peek(System.out::println).filter(str->str.length()>7).map(String::toUpperCase).peek(System.out::println).findFirst()
				
				
				);
		
		
		/*
		  Here the algorithm would not filter all the strs whose length is >7 , all the intermediate operations are Laze
		  It checks the terminal operation findFirst - Then it knows that we need to find only the first element
		  As soon as the filter finds the first element it then executes the intermediate operations like map(UpperCase)
		  then the peek() . So this way it does not even filter all the elements, performance improvement
		 	
		 */
		
		
		//Terminal operation
		
		System.out.println(
				
				course.stream().peek(System.out::println).filter(str->str.length()>7).map(String::toUpperCase).peek(System.out::println)
				);
		
		
	//java.util.stream.ReferencePipeline$15@1761e84
	
	
	 //The above has just created a stream pipeline. It will only perform the lazy operations only when the terminal operation is invoked

	 Stream<String> temp= course.stream().peek(System.out::println).filter(str->str.length()>7).map(String::toUpperCase).peek(System.out::println);
	 
	 System.out.println(temp.findFirst());
	 
	}
}
