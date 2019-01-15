package com.zhy.java8;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean compare(T t);
	
}

