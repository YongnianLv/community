package com.community.service;

import com.community.dao.DaoDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lyn
 * @tip Come on!Do your way best!
 * @create 2021.03.24.18:16
 */
@Service
public class ServiceTest {
    @Autowired
    private DaoDemo daoDemo;
    public ServiceTest() {
        System.out.println("实例化中。。。");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化中。。。");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁中。。。");
    }
    public String find(){
        return daoDemo.select();
    }
}
