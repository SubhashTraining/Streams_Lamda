package com.java.functionalinterface;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.*;
import java.util.stream.*;

class course{
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	public course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	public String toString() {
		return name+":"+reviewScore+":"+category+":"+noOfStudents;
	}
	
	
}


public class FI06_CustomClass_Matches {
	
	
	public static void main(String args[]) {
		
		List<course> list = List.of(new course("Java","CS",90,120),
									new course("Mama","CS",95,80),
									new course("Jaamamam","Social",85,42),
									new course("Jaamamam_2","Social",85,90),
									new course("Gamamama","Science",90,34),
									new course("Daamanan","Science",65,85),
									new course("Bramaha","Web",83,96));
		
		
		
		Predicate<course> ReviewScoreGreaterThan60Predicate = course->course.getReviewScore()>60;
		Predicate<course> ReviewScoreGreaterThan95Predicate = course->course.getReviewScore()>=95;
		
		
		System.out.println(list.stream().allMatch(ReviewScoreGreaterThan60Predicate));//true
		System.out.println(list.stream().allMatch(ReviewScoreGreaterThan95Predicate));//false
		
		
		
		
		//none should match the below criteria
		Predicate<course> ReviewScoreLessThan65Predicate = course->course.getReviewScore()<65;
		System.out.println(list.stream().noneMatch(ReviewScoreLessThan65Predicate));//true
		
		
		
		
		
		//anyMatch if any of it matches
		
		Predicate<course> ReviewScoreLessThan80Predicate = course->course.getReviewScore()<80;
		System.out.println(list.stream().anyMatch(ReviewScoreLessThan80Predicate));//true
		
		
		//Comparator
		
		Comparator<course> compareByNoOfStudents = Comparator.comparing(course::getNoOfStudents);
		Consumer<course> toStringConsumer = System.out::println;
		//Consumer<course> toStringConsumer = course-> System.out.println(course);//Can also be used
		list.stream().sorted(compareByNoOfStudents).forEach(toStringConsumer);
		
				
		System.out.println("******************************************");
		Comparator<course> compareByNoOfStudentsDescending = Comparator.comparing(course::getNoOfStudents).reversed();
		list.stream().sorted(compareByNoOfStudentsDescending).forEach(toStringConsumer);
		
		
		
		
		//Mutliple comparator-- Here there are two courses with revew score 85which are then sorted by student count
		System.out.println("******************************************");
		Comparator<course> compareByNoReviewScoreNoOfStudents = Comparator.comparing(course::getReviewScore).thenComparing(course::getNoOfStudents).reversed();
		list.stream().sorted(compareByNoReviewScoreNoOfStudents).forEach(toStringConsumer);
		
		
		
		
		//Limit top2
		System.out.println("****************Limit**************************");
		list.stream().sorted(compareByNoReviewScoreNoOfStudents).limit(3).forEach(toStringConsumer);
		
		
		
		
		//Skip top 3
		System.out.println("****************Limit**************************");
		list.stream().sorted(compareByNoReviewScoreNoOfStudents).skip(3).forEach(toStringConsumer);
		
		
		//Take While . this will start processing from the first element and see if it meets the predicate. 
		//If any violates the condition it will skip all the rest. Like while loop if the condition fails it exits
		System.out.println("****************TakeWHile**************************");
		Predicate<course> reviewScoreGreaterThan90 = course-> course.getReviewScore()>=90;
		list.stream().takeWhile(reviewScoreGreaterThan90).forEach(toStringConsumer);
		
		
		//DropWhile - The skipped elements in the Take While will be considered. Negation of Take While
		System.out.println("****************DropWhile**************************");
		list.stream().dropWhile(reviewScoreGreaterThan90).forEach(toStringConsumer);
		
		
		
		
		//Max - The last element
		System.out.println("****************Max**************************");
		System.out.println(list.stream().max(compareByNoReviewScoreNoOfStudents).toString());
		
		//Min - the first element
		System.out.println("****************Min**************************");
		System.out.println(list.stream().min(compareByNoReviewScoreNoOfStudents).toString());
		
		//If it returns Optional Empty we can specify orElse
		//OrElse - If no results exists
		System.out.println("*****OR Else*************************");
		Predicate<course> ReviewScoreGreaterThan96Predicate = course->course.getReviewScore()>96;
		
		System.out.println(list.stream().filter(ReviewScoreGreaterThan96Predicate).min(compareByNoReviewScoreNoOfStudents)
		.orElse(new course("newCourse","OrElese",97,456)));
		
		
		
		//findFirst - FirstElement that meets the specific criteria
		System.out.println("*****Find First*************************");
		System.out.println(
				list.stream().filter(ReviewScoreGreaterThan60Predicate).findFirst()
				);
		
		
		//findAny Condition - returns any element that meets the condition
		System.out.println("*****Find Any*************************");
		System.out.println(
				list.stream().filter(ReviewScoreGreaterThan60Predicate).findAny()
				);
		
		
		//Sum
		System.out.println("*****Sum -- Map To Int*************************");//Convert the IntegerStream to intStream
		System.out.println(
				list.stream().filter(ReviewScoreLessThan80Predicate).mapToInt(course::getNoOfStudents).sum()
				);
		
		System.out.println("*****Average -- Map To Int*************************");//Convert the IntegerStream to intStream
		System.out.println(
				list.stream().filter(ReviewScoreGreaterThan60Predicate).mapToInt(course::getNoOfStudents).average()
				);
		
		
		System.out.println("*****Count -- Map To Int*************************");//Convert the IntegerStream to intStream
		System.out.println(
				list.stream().filter(reviewScoreGreaterThan90).mapToInt(course::getNoOfStudents).count()
				);
		
		
		
		
		
		
		//Collectors.grouping by very important - group by map
		System.out.println("*****Grouping*************************");
		System.out.println(
				list.stream().collect(Collectors.groupingBy(course::getCategory))
				);
		
		
		System.out.println("*****Grouping -Map*************************");
		Map<String,List<course>> groupMap =list.stream().collect(Collectors.groupingBy(course::getCategory));
		System.out.println(groupMap);
		
		
		System.out.println("*****Grouping by Category, Calculate Count*************************");
		
		Map<String,Long> groupMapCount =list.stream().collect(Collectors.groupingBy(course::getCategory,Collectors.counting()));
		System.out.println(groupMapCount);
		
		
		
		System.out.println("*****Grouping by Category,MaxBy ***********");
		
		Map<String,Optional<course>> groupMapMaxBy =list.stream().collect(Collectors.groupingBy(course::getCategory,
				                                             Collectors.maxBy(Comparator.comparing(course::getReviewScore))));
		System.out.println(groupMapMaxBy);
		
		
		
		System.out.println("*****Grouping by Category,Mapping ***********");
		
		Map<String,List<String>> groupingMapping = list.stream().collect(Collectors.groupingBy(course::getCategory,
														Collectors.mapping(course::getName, Collectors.toList())));
		System.out.println(groupingMapping);
		
		
	}

}
