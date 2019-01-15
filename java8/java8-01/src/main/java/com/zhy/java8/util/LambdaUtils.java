package com.zhy.java8.util;

import java.util.function.Consumer;

public class LambdaUtils {
	
	public static <T> void accept(T t,Consumer<T> c) {
		c.accept(t);
	}

}
