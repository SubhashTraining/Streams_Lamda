package com.java.functionalinterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FI13_Files {

	
	public static void main(String args[]) throws IOException {
		
		
		Files.lines(Path.of("file.txt"))
			.forEach(System.out::println);
		
		
		
		
		
				
				Files.lines(Path.of("file.txt"))
				.map(lines->lines.split("")).flatMap(Arrays::stream).forEach(System.out::println);
				
				
				System.out.println("*************Distinct words in Files*****************");
				
				Files.lines(Path.of("file.txt"))
				.map(lines->lines.split(" ")).flatMap(Arrays::stream).distinct().sorted().forEach(System.out::println);
						
				
				
				Files.list(Path.of(".")).filter(f->Files.isDirectory(f)).forEach(System.out::println);
				
				Files.list(Path.of(".")).filter(Files::isDirectory).forEach(System.out::println);
		
	}
}
