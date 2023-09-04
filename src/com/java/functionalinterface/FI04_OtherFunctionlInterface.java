package com.java.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.Random;
public class FI04_OtherFunctionlInterface {

	
	//Supplier - takes no argument and return a value
	public static void main(String args[]) {
		
		//Supplier no input -> Returns something
		Supplier<Integer> supplier = ()-> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		
		Supplier<Integer> sup = new Supplier<>() {

			@Override
			public Integer get() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		
		
		System.out.println(supplier.get());//258
		System.out.println(sup.get());//null
		
		
		
		//Unary Operator
		
		UnaryOperator<Integer> uO = x-> x*x;
		System.out.println(uO.apply(4));//16
		
		//BiPredicate takes two argument
		BiPredicate<Integer,String> bP = (x,y)-> (x>5 && y.length()>3);//true
		System.out.println(bP.test(10, "Sanjay"));
		//the output is boolean
		
		
		//BiFunction takes two argument
		BiFunction<Integer,String,String> bifunction;
		//Arg1, Arg2, Return Type
		
		//BiConsumer takes two arg and does not return anything
		
		
	}
}
