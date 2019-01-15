package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {//boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml

	@Bean
	@LoadBalanced		 //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套 客户端的负载均衡工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	//显示的指定IRule的负载均衡算法，替代默认的轮询。  @RibbonClient指定的算法会覆盖该算法
	@Bean
	public IRule myRule() {
		// return new RoundRobinRule();
//		return new RandomRule();
		return new RetryRule();
	}
}
