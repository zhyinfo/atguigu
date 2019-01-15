package com.zhy.java8;

import com.zhy.java8.defaultmethod.MyInterface;
import com.zhy.java8.defaultmethod.SubClass;
/**
 * No.12
 */
public class TestDefaultInterface {
	
	public static void main(String[] args) {
		SubClass sc = new SubClass();
		System.out.println(sc.getName());
		
		MyInterface.show();
	}

}
