package com.java.functionalinterface;

import java.util.stream.LongStream;

public class FI11_Parralelization {
	
	public static void main(String agrs[]) {
		
		
		Long time = System.currentTimeMillis();
		
		
		
		System.out.println(
				LongStream.range(0, 1000000000).sum()
		);
		System.out.println(time- System.currentTimeMillis());
		
		
		// These operations takes time to execute. We can ask the streams to run this in parallel by just specifying
		
		
		System.out.println(
				LongStream.range(0, 1000000000).parallel().sum()
		);
		
	}

}
