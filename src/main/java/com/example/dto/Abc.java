package com.example.dto;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

@Component
public class Abc {
	public void check() {
		LinkedList<String> proverbs = new LinkedList<>();
	    LinkedList<Double> numbers = new LinkedList<>();
	    
	    System.out.println("numbers class name " + numbers.getClass().getName());
	    System.out.println("proverbs class name " + proverbs.getClass().getName());
	    System.out.println("Compare Class objects: " +
	                               numbers.getClass().equals(proverbs.getClass()));

	}
}
