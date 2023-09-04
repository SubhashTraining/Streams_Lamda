package com.java.streams.api;

import java.util.List;

public class streams5 {
	
	public static void main(String args[]) {
		
		List<String> sList = List.of("java","Maava","Bava","Kava");
		
		
		sList.stream().
				filter(course->course.contains("java")).
				forEach(System.out::println);
		
		sList.stream()
		.filter(course-> course.length()>=4)
		.forEach(System.out::println);
		
		System.out.println("No of Charatcers in each courses");
		sList.stream()
		.map(course-> course.length())
		.forEach(System.out::println);
		
	}

}
