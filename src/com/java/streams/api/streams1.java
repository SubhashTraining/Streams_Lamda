package com.java.streams.api;

import java.util.List;
import java.util.stream.Stream;
import java.lang.Math;
public class streams1 {

	public static void main(String args[]) {
		
		List<Integer> list = List.of(54,77,44,212,24,245,54,14);
		streameg(list);
	}
	
	static void print(int n) {
		System.out.println(n);
	}
	
	static boolean even(int n) {
		return n%2==0;
	}
	static void streameg(List<Integer> list) {
		
		list.stream().forEach(streams1::print);
		// we are specifying the class name:: and the method name(static)
		// parameter is for each value		
		list.stream().forEach(System.out::println);
		
		list.stream().filter(streams1::even).forEach(System.out::println);
		
		System.out.println("**************************");
		
		
		list.stream().filter(n-> n%2==0).forEach(System.out::println);
		
			
		Stream<String> stream = List.of("java","Oracle","Ora","Bara","Chara").stream();
		stream.filter(s-> s.startsWith("O")).forEach(System.out::println);
		
		
		System.out.println("*************Mapping*********");
		//Mapping
		Stream<Integer> streamInt = list.stream();
		
		streamInt
		.filter(n-> !(n%2==0))
		.map(n-> n*n*n)
		.forEach(System.out::println);
		
		
		
		
		
		
		
	}
}
