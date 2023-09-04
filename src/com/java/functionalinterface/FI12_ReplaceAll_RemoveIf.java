package com.java.functionalinterface;

import java.util.List;
import java.util.ArrayList;

public class FI12_ReplaceAll_RemoveIf {

	
	
	
	public static void main(String args[]) {
		
		
		
		List<String> course = List.of("Java","Spring Boot","AWS","Delta Corp","DD","GDS","Algorithm");
		
		//List created using List.of -> Is unmodifyiable list
		
		/*
		course.remove(1); //java.lang.UnsupportedOperationException.. Immutable Collection Execption
		*/
		
		
		List<String> newCourse = new ArrayList<>(course);
		
		newCourse.replaceAll(str->str.toUpperCase());
		System.out.println(newCourse);
		
		// The replace all Function as an argument has been added to List and Sets
		
		newCourse.removeIf(n->n.length()>4);
		System.out.println(newCourse);
		
		
		
	}
	
}
