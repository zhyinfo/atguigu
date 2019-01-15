package com.atguigu.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.atguigu.bean.Car;

/**
 * bean���������ڣ�
 * 		bean����---��ʼ��----���ٵĹ���
 * 
 * ���죨���󴴽���
 * 		��ʵ����������������ʱ�򴴽�����
 * 		��ʵ������ÿ�λ�ȡ��ʱ�򴴽�����
 * 
 * ��������bean���������ڣ�
 * 		�����Զ����ʼ�������ٷ�����������bean���е���ǰ�������ڵ�ʱ�������������Զ���ĳ�ʼ�������ٷ���
 * 
 * 		1����ָ����ʼ�������ٷ�����
 * 	       		ͨ��@Beanָ��init-method��destroy-method��
 * 		2����ͨ����Beanʵ��InitializingBean��afterPropertiesSet():�����ʼ���߼�����DisposableBean��destroy():���������߼���;
 * 		3��������ʹ��JSR250�淶�����ע�⣺
 * 				@PostConstruct����bean������ɲ������Ը�ֵ��ɣ���ִ�г�ʼ������(��������ϵע�����֮����Ҫִ�еķ���)
 * 				@PreDestroy������������bean֮ǰ֪ͨ���ǽ���������
 * 		4����BeanPostProcessor��interface����bean�ĺ��ô�������
 * 	      		��bean�ĳ�ʼ������(init)ǰ�����һЩ��������
 * 				postProcessBeforeInitialization:�ڳ�ʼ��֮ǰ����
 * 				postProcessAfterInitialization:�ڳ�ʼ��֮����
 * 
 * 		*Spring�ײ�� BeanPostProcessor ��ʹ��:
 * 				bean��ֵ��ע�����������@Autowired����������ע�⹦�ܣ�@Async,xxx BeanPostProcessor;
 * 
 * 
 * 
 * BeanPostProcessor.postProcessBeforeInitialization
 * ��ʼ����
 * 		���󴴽���ɣ�����ֵ�ã�֮����ó�ʼ������.
 * BeanPostProcessor.postProcessAfterInitialization
 * 
 * ���٣�
 * 		��ʵ���������رյ�ʱ��
 * 		��ʵ������������������bean����������������ٷ�����
 * 
 * 
 * �����õ����������е�BeanPostProcessor������ִ��beforeInitialization��
 * һ������null������forѭ��������ִ�к����BeanPostProcessor.postProcessorsBeforeInitialization
 * 
 * BeanPostProcessorԭ��
 * populateBean(beanName, mbd, instanceWrapper);��bean�������Ը�ֵ
 * initializeBean
 * {
 * 	applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * 	invokeInitMethods(beanName, wrappedBean, mbd);ִ���Զ����ʼ������
 * 	applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * } 
 *
 */
@ComponentScan("com.atguigu.bean")
@Configuration
public class MainConfigOfLifeCycle {
	
	//@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="detory")
	public Car car(){
		return new Car();
	}

}
