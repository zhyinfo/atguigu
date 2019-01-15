package com.zhy.java8;

import java.util.stream.Stream;

import org.junit.Test;

import com.zhy.java8.annotation.MyAnnotation;

/**
 * No.15 重复注解与类型注解
 */
public class TestAnnotation {
	
	@MyAnnotation("hello")
	@MyAnnotation("world")
	public void show(@MyAnnotation("oh") String arg) {
		
	}
	
	@Test
	public void test() throws Exception {
		Stream.of(TestAnnotation.class.getMethod("show").getAnnotationsByType(MyAnnotation.class))
			  .map(MyAnnotation::value)
			  .forEach(System.out::println);
	}

}
