package com.java.functionalinterface;


import java.util.*;
import java.util.stream.Collectors;
public class FI08_StringsJoiningFlatMaps {
	
	public static void main(String args[]) {
		
		
		List<String> courses = List.of("Java", "Spring Boot","AWS","Azure","DevOps");
		
		//"spring".split("") ---> String[6]  -- splitng a string will result in Array of Strings
		// String[6]{"s","p","i","n","g"}
		
		
		System.out.println(
				courses.stream().map(str-> str.split(""))
						);
		//java.util.stream.ReferencePipeline$3@5679c6c6
		//this results in a Stream of String arrays. To have all the arrays together in a single stream of String
		//we use flatmap
		
		System.out.println(
				courses.stream().map(str->str.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
				
				);

		//[J, a, v, a, S, p, r, i, n, g,  , B, o, o, t, A, W, S, A, z, u, r, e, D, e, v, O, p, s]
		
		
		/*
		  FlatMap -> each element of the Stream replaced with the content of mapped stream. 
		  Mapping function (Arrays::stream)
		  
		  ["s","p","r","i","n","g"]=> "s","p","r","i","n","g"
		 
		 
		 	We got a stream of string arrays, now we need to flatten up the stream array to Stream of string
		 
		 */
		
		
		
		List<String> courses2 = List.of("Java", "Spring Boot","AWS","Azure","DevOps");
		
		System.out.println(
				
				courses.stream()
				.flatMap(course1-> courses2.stream().map(course2-> List.of(course1,course2)))
				.collect(Collectors.toList())
						
				
				);
		
		
		//Filter tupules whose size are equal
		System.out.println(
				
				courses.stream()
				.flatMap(course1-> courses2.stream().map(course2-> List.of(course1,course2)))
				.filter(list-> list.get(0).length()==list.get(1).length())
				.collect(Collectors.toList())
						
				
				);
		
		System.out.println(
				
				courses.stream()
				.flatMap(course1-> courses2.stream().map(course2-> List.of(course1,course2)))
				.filter(list-> list.get(0).equals(list.get(1)))
				.collect(Collectors.toList())
						
				
				);
		
		
		
		
		
		
		
		
		
		//practice
		
		List<String> corse1 = List.of("Java", "Spring Boot","AWS","Azure","DevOps");
		List<String> corse2= List.of("Java", "Spring Boot","AWS","Azure","DevOps");
		
		System.out.println(
				corse1.stream().flatMap(co1-> corse2.stream().map(co2-> List.of(co1,co2)))
				.collect(Collectors.toList())
				
				);
		
		
		//[java.util.stream.ReferencePipeline$3@de0a01f, java.util.stream.ReferencePipeline$3@4c75cab9, java.util.stream.ReferencePipeline$3@1ef7fe8e, java.util.stream.ReferencePipeline$3@6f79caec, java.util.stream.ReferencePipeline$3@67117f44]

		
		
		
		
		
		
		
		
		
		
	}

}
