package com.java.functionalinterface;

import java.util.*;
import java.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FI01 {
	
	public static void main(String args[]) {
		
		
		Stream<Integer> stream = List.of(33,23,45,675,444,225,235).stream();
		
		stream.filter(n->n%2==0).map(n-> n*n).forEach(System.out::println);
		
		/*
		  	java.util.stream.Stream.filter(Predicate<? super Integer> predicate)
		  	-- is a Predicated which inturn is a functional interface which has an 1 abstract method
		  	-- named test() which returns a boolean value
		  	-- import java.util.function.Predicate
		 */
		
		Predicate<Integer> predicate= new Predicate<>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				 return t%2==0;
			}

						
		};
		
		
		/* 
		 	java.util.stream.Stream.map(Function<? super Integer, ? extends Integer> mapper)
		  	-- stream.map accept a functinalInterface Function and returns type R
		  	-- java.util.function.Function
		  			  
		 */
		
		
		Function<Integer,Integer> function = new Function<>() {

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*t;
			}

			
		};
		
		
		/*
		 	 java.util.stream.Stream.map(Function<? super Integer, ? extends Integer> mapper)
		 	 -- Stream.map accepts a functional inteface named Consumer which consumes the input and 
		 	 -- does not return any value or returns void
		 	 
		 	 -- java.util.function.Consumer
		 */
		
		
		Consumer<Integer> consumer = new Consumer<>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

					
			
		};
		
		
		System.out.println("*********************************************");
		stream = List.of(33,23,45,675,444,44,12,225,235).stream();
		
		stream.filter(predicate).map(function).sorted().forEach(consumer);
		
		
		Function<Integer,Integer> fun = x-> x*x;
		Consumer<Integer> con = System.out::println;
		Predicate<Integer> pred = n-> n%2==0;
		
		// the above lambda expression will create an instance of the appropriate functio
		
		
	}

}
