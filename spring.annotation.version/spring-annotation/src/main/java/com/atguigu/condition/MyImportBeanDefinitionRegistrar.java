package com.atguigu.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.atguigu.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata����ǰ���ע����Ϣ
	 * BeanDefinitionRegistry:BeanDefinition��ע���ࣻ
	 * 		����Ҫ��ӵ������е�bean,���Ե���BeanDefinitionRegistry.registerBeanDefinition�ֹ�ע�����
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		
		boolean definition = registry.containsBeanDefinition("com.atguigu.bean.Red");
		boolean definition2 = registry.containsBeanDefinition("com.atguigu.bean.Blue");
		if(definition && definition2){
			//ָ��Bean������Ϣ����Bean�����ͣ�Bean��������
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			//ע��һ��Bean��ָ��bean��
			registry.registerBeanDefinition("rainBow", beanDefinition);
		}
	}

}
