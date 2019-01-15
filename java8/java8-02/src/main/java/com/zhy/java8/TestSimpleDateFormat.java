package com.zhy.java8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.zhy.java8.newdate.DateFormatThreadLocal;
/**
 * No.13
 */
public class TestSimpleDateFormat {
	
	public static void main(String[] args) throws Exception {
		
//		traditionalDateApi();
		
		newDateApi();
	}
	
	public static void traditionalDateApi() throws Exception {
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Callable<Date> task = new Callable<Date>() {
//
//			@Override
//			public Date call() throws Exception {
//				return sdf.parse("20161121");
//			}
//			
//		};
		
		//解决多线程安全问题
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return DateFormatThreadLocal.convert("20161121");
			}
			
		};

		List<Future<Date>> results = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		
		for (Future<Date> future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}
	
	public static void newDateApi() throws Exception {
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		Callable<LocalDate> task = new Callable<LocalDate>() {

			@Override
			public LocalDate call() throws Exception {
				LocalDate ld = LocalDate.parse("20161121", dtf);
				return ld;
			}
			
		};
		
		List<Future<LocalDate>> results = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		
		for (Future<LocalDate> future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}

}
