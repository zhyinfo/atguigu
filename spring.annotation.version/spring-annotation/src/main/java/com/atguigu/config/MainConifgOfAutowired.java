package com.atguigu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.dao.BookDao;


/**
 * 自动装配;
 * 		Spring利用依赖注入（DI），完成对IOC容器中中各个组件的依赖关系赋值；
 * 
 * 1）、@Autowired：自动注入：
 * 		1）、默认优先按照【类型】去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值
 * 
 * 		2）、如果找到多个相同类型的组件，默认再将属性的【名称】作为组件的id去容器中查找 applicationContext.getBean("bookDao")
 * 
 * 		3）、@Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 * 
 * 		4）、自动装配默认一定要将属性赋值好，没有就会报错；可以使用@Autowired(required=false);
 * 
 * 		5）、@Primary：在Spring容器管理同类型的多个bean时，可以使用@Primary注解,那么在进行自动装配的时候，默认使用首选的bean；
 * 				            也可以继续使用@Qualifier指定需要装配的bean的名字
 * 		BookService{
 * 			@Autowired
 * 			BookDao  bookDao;
 * 		}
 * 
 * 2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 * 		@Resource:
 * 			可以和@Autowired一样实现自动装配功能；默认是按照组件【名称】进行装配的；
 * 			没有支持@Primary功能，也没有支持@Autowired（reqiured=false）;
 * 		@Inject:
 * 			需要导入javax.inject的包，和Autowired的功能一样。只是没有required=false的功能；
 * 
 *  @Autowired:Spring定义的； @Resource、@Inject 都是java规范
 * 	
 * AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能；		
 * 
 * 3）、 @Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值
 * 		1）、[标注在方法位置]：@Bean + 方法参数 ；参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配
 * 		2）、[标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 * 		3）、放在参数位置：同上一样
 * 
 * 4）、自定义组件如果想要使用Spring容器底层的一些组件（e.g: ApplicationContext，BeanFactory，xxx）；
 * 		只需让自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件;
 * 		把Spring底层一些组件注入到自定义的Bean中；
 * 		xxxAware：功能使用xxxProcessor；
 * 			ApplicationContextAware==》ApplicationContextAwareProcessor；
 * 	
 * 		
 * @author lfy
 *
 */
@Configuration
@ComponentScan({"com.atguigu.service","com.atguigu.dao",
	"com.atguigu.controller","com.atguigu.bean"})
public class MainConifgOfAutowired {
	
//	@Primary
	@Bean("bookDao2")
	public BookDao bookDao(){
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}
	
	/**
	 * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
	 * @param car
	 */
//	@Autowired
	@Bean
	public Color color(Car car){
		Color color = new Color();
		color.setCar(car);
		return color;
	}
	

}
