package com.atguigu.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.bean.Blue;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;

public class IOCTest {
	
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
	
	@Test
	public void testImport() {
		printBeans(ctx);
		
		Blue bean = ctx.getBean(Blue.class);
		System.out.println(bean);
		
		//工厂bean获取的是调用getObject创建的对象,不是colorFactoryBean
		Object bean2 = ctx.getBean("colorFactoryBean");
		System.out.println("bean的类型是:"+bean2.getClass());
	}
	
	@Test
	public void test03(){
		String[] namesForType = ctx.getBeanNamesForType(Person.class);
		for (String name : namesForType) {
			System.out.println(name);
		}
		
		Map<String, Person> persons = ctx.getBeansOfType(Person.class);
		System.out.println(persons);
	}
	
	
	@Test
	public void test02(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
		
		System.out.println("ioc容器创建完成...");
		
		Object bean = ctx.getBean("person");
		Object bean2 = ctx.getBean("person");
		System.out.println(bean == bean2);
	}
	
	@Test
	public void test01(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
		
		printBeans(ctx);
	}

	private void printBeans(AnnotationConfigApplicationContext ctx) {
		String[] names = ctx.getBeanDefinitionNames();
		
		for (String name : names) {
			System.out.println(name);
		}
	}

}
