package com.atguigu.springboot.repository;

import com.atguigu.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作  <User,Integer> //User -> 实体类型，Integer-> 实体中主键的类型
//自动注入
public interface UserRepository extends JpaRepository<User,Integer> {
}
