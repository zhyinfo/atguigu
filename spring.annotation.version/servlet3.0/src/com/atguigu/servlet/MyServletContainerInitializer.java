package com.atguigu.servlet;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import com.atguigu.service.IHelloService;

/**
 * 容器启动的时候会将@HandlesTypes指定的这个类型下面的<b>子类(实现类，子接口等)</b>传递过来；、
 */
@HandlesTypes(value={IHelloService.class}) //传入感兴趣的类型；
public class MyServletContainerInitializer implements ServletContainerInitializer {

	/**
	 * 应用启动的时候，会运行onStartup方法；
	 * 
	 * Set<Class<?>> arg0：感兴趣的类型的所有子类型；@HandlesTypes指定
	 * ServletContext ctx:代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
	 * 
	 * 1）、使用ServletContext注册Web组件（Servlet、Filter、Listener）
	 * 
	 * 2）、使用编码的方式，在项目启动的时候给ServletContext里面添加组件；
	 * 	 	必须在项目启动的时候来添加；
	 * 		1）、ServletContainerInitializer得到的ServletContext；
	 * 		2）、ServletContextListener得到的ServletContext；
	 */
	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext ctx) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("感兴趣的类型：begin..");
		for (Class<?> claz : arg0) {
			System.out.println(claz);
		}
		System.out.println("感兴趣的类型：end..");
		
		//注册组件  ServletRegistration  
		ServletRegistration.Dynamic servlet = ctx.addServlet("userServlet", new UserServlet());
		//配置servlet的映射信息
		servlet.addMapping("/user");
		
		//注册Filter  FilterRegistration
		FilterRegistration.Dynamic filter = ctx.addFilter("userFilter", UserFilter.class);
		//配置Filter的映射信息
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
				
		//注册Listener
		ctx.addListener(UserListener.class);
		
		
		
	}

}
