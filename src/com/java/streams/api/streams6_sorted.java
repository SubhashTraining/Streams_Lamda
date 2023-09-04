package com.java.streams.api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class streams6_sorted {

	
	public static void main(String args[]) {
		
		Stream<String> stream = List.of("java","Oracle","Ora","Bara","Chara").stream();
		stream.distinct().sorted().forEach(System.out::println);
		
		
		System.out.println("******************************");
		//Natural Order or Ascending Order Sorted
		stream = List.of("java","Oracle","Ora","Bara","Chara").stream();
		stream.distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
		System.out.println("**************Reverse Order****************");
		stream = List.of("java","Oracle","Ora","Bara","Chara").stream();
		stream.distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("**************Length Order****************");
		stream = List.of("java","Oracle","Ora","Bara","Chara").stream();
		stream.distinct().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
		
			
	}
}
