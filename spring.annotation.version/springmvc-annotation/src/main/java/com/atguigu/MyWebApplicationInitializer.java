package com.atguigu;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.atguigu.config.AppConfig;
import com.atguigu.config.RootConfig;

/**
 * web容器启动的时候创建对象；调用方法(onStartup)来初始化容器以及前端控制器
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements ServletContextAware {

	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	
	/**
	 * 获取根容器的配置类；（Spring的配置文件）   父容器；
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	/**
	 * 获取web容器的配置类（SpringMVC配置文件）  子容器；
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}

	/** 
	 * 获取DispatcherServlet的映射信息   <servlet-mapping>
	 *	/：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括 *.jsp；
	 *	/*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	
	
	//注册web三大组件
	
	//servlet 通过 servletContext 注册
	
	//注册filer
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return super.getServletFilters();
	}

	//注册listener
	@Override
	protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
		// TODO Auto-generated method stub
		return super.getRootApplicationContextInitializers();
	}

	

	

}
