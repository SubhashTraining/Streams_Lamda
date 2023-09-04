package com.java.functionalinterface;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FI07_StreamsPrimitivesArrays {
	
	public static void main(String args[]) {
		
		Stream<Integer> stream = Stream.of(45,875,54,51,26,45,47);
		System.out.println(stream);
		//java.util.stream.ReferencePipeline$Head@6f75e721
		
		
		System.out.println(List.of(45,875,54,51,26,45,47).stream());
		//java.util.stream.ReferencePipeline$Head@33833882
		
		
		
		
		//These are streams of Integers. What if we want to have streams of primitives
		// We use arrays
		
		
		int[] arrays = {12,54,147,152,64};
		System.out.println(
				Arrays.stream(arrays)			
				);
		//java.util.stream.IntPipeline$Head@5680a178
		//you can directly apply sum average and count on int streams
		System.out.println(
				Arrays.stream(arrays).sum()			
				);
		
		System.out.println(
				Arrays.stream(arrays).average()			
				);
		
		System.out.println(
				Arrays.stream(arrays).count()		
				);
		
		
		
		
		
		
		
		//Primitive Stream
		
		System.out.println(IntStream.range(1, 100).sum());//4950
		System.out.println(IntStream.range(1, 100).count());//99
		//this includes 1-99
		
		System.out.println(IntStream.rangeClosed(1, 100).count());//100
		
		
		
		
		System.out.println(
				IntStream.iterate(1, n->n+2).limit(10).peek(System.out::println).sum()
				);//100
		//peek is a consumer on the int stream
		
		
		
		
		
		//you cant apply collect on primitives stream. you need to apply boxed them to wrapper class
		
		System.out.println(
				
				IntStream.iterate(1, n->n*2).limit(10).boxed().collect(Collectors.toList())
				
				);
		//you can create DoubleStream LongStream etc
		
		
		
		
		System.out.println(
				LongStream.range(1, 30).reduce(1,(x,y)->x*y)
				);
		//The result has crossed the range of long : -7055958792655077376

		
		System.out.println(
				LongStream.range(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,
												BigInteger::multiply)
				);
		
		//608281864034267560872252163321295376887552831379210240000000000
		
		
		
		
		
	}

}
