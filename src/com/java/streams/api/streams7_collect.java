package com.java.streams.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streams7_collect {
	
	public static void main(String args[]) {
		
		Stream<String> streamS = List.of("java","Oracle","Ora","Bara","Chara").stream();
		System.out.println(streamS.filter(str-> str.length()>=4).collect(Collectors.toList()));
		
		System.out.println("*********************************");
		Stream<Integer> streamI = List.of(55,85,74,665,214,525,25).stream();
		System.out.println(streamI.filter(n->n%2==0).collect(Collectors.toList()));
		
		
	}

}
