package com.example.utils;

public class StackPlayground {
	
	private int[] arr;
	// initially the stack is empty
	private int top = -1;
	
	public StackPlayground(int size) {
		arr = new int[size];
		this.top = size;
	}
	
	public void push(int value) {
		if(top <= 0) {
			System.out.println("Stack Overflow! No room exists");
			return;
		}
		--top;
		arr[top] = value;
	}
	
	public int pop() {
		if(arr.length > 0 && top == this.arr.length) {
			System.out.println("Stack is Empty");
			return -1;
		}
		
		int temp = arr[top];
		arr[top] = 0;
		++top;
		return temp;
	}
	
	public int peek() {
		if(!isEmpty()) {
			return arr[top];
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return arr.length == 0 || top == this.arr.length;
	}
	
	public void search(int value) {
		
	}
	
	

}
