package com.java.functionalinterface;

import java.util.List;
import java.util.stream.Stream;
import java.util.function.BinaryOperator;
import java.util.function.Function;

//Find functional interface behind the reduce method. reduce(0,Integer::Sum)
public class FI02 {
	
	public static void main(String args[]) {
		
		Stream<Integer> stream = List.of(33,23,45,675,444,225,235).stream();
		
		System.out.println(stream.reduce(0,Integer::sum));
		
		/*
		 	 java.util.stream.Stream.reduce(Integer identity, BinaryOperator<Integer> accumulator)
		 	 Represents an operation upon two operands of the same type, 
		 	 producing a resultof the same type as the operands. 
		 	 This is a specialization of BiFunction for the case where the operands 
		 	 and the result are all ofthe same type. 
		 */
		
		
		BinaryOperator<Integer> Sum = new BinaryOperator<>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t+u;
			}

			
			
		};
		
		System.out.println("Binary Operator");
		stream = List.of(33,23,45,675,444,225,235).stream();
		
		System.out.println(stream.reduce(0,Sum));
		
		 
		BinaryOperator<Integer> bo = Integer::sum;
		
		
	}

}
