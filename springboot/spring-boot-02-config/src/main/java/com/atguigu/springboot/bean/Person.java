package com.atguigu.springboot.bean;


import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *  prefix = "person"：从配置文件中哪个下面的所有属性进行一一映射
 *
 *  只有这个类是容器中的组件，容器才能提供@ConfigurationProperties功能；
 *  @ConfigurationProperties(prefix = "person") 默认从全局配置文件中获取值；
 *  @ConfigurationProperties 支持JSR303数据校验
 *
 * 	使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值
 */
//@Validated
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
@Component
public class Person {

    /**
     * <bean class="Person">
     *      <property name="lastName" value="字面量 / ${key}从环境变量、配置文件中获取值 / #{SpEL}"></property>
     * <bean/>
     */

    //@Email // lastName必须是邮箱格式
    //@Value("${person.last-name}")
    private String lastName;
    
    //@Value("#{11*2}")
    private Integer age;
    
    //@Value("true")
    private Boolean boss;

    private Date birth;
    
    //@Value("${person.maps}") //@Value不支持复杂类型的封装
    private Map<String,Object> maps;
    
    private List<Object> lists;
    
    private Dog dog;

    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", boss=" + boss + ", birth=" + birth + ", maps="
				+ maps + ", lists=" + lists + ", dog=" + dog + "]";
	}
    
    
}
