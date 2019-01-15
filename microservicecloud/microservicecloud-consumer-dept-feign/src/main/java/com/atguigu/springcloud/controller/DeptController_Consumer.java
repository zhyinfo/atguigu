package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return this.service.discovery();
	}
	
	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return this.service.list();
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Object add(Dept dept) {
		return this.service.add(dept);
	}
	
///****  ribbon + RestTemplate

//	//Ribbon和Eureka整合后Consumer可以直接调用服务而不用再关心地址和端口号
//	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	//测试@EnableDiscoveryClient,消费端可以调用服务发现
//	@RequestMapping(value = "/consumer/dept/discovery")
//	public Object discovery() {
//		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
//	}
//
//	
//	@RequestMapping(value = "/consumer/dept/add")
//	public boolean add(Dept dept) {
//		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
//	}
//
//	@RequestMapping(value = "/consumer/dept/get/{id}")
//	public Dept get(@PathVariable("id") Long id) {
//		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
//	}
//
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = "/consumer/dept/list")
//	public List<Dept> list() {
//		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
//	}
}
