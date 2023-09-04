package com.java.functionalinterface;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
public class FI05_methodReferences {
	
	public static void main(String args[]) {
		
		List<String> list = List.of("Sam","Jam","nam");
		 
		list.stream().map(String::toUpperCase).forEach(System.out::println);
		
		// Here println is a static method in System.out class, we can call static methods on each items
		// toUpperCase is a class non static method that is call on objects, we can even call those ref
		
		
		//Constructor reference
		Supplier<String> suppier = ()-> new String();
		
		Supplier<String> supplier2 = String::new;//returns a new STring object
		System.out.println(supplier2.get());//""
		
		Function<String,String> fun = String::new;
		System.out.println(fun.apply("Subhash"));
	}

}
