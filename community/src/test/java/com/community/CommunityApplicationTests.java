package com.community;

import com.community.dao.DaoDemo;
import com.community.service.ServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}
	@Test
	public void testApplicationContext() {
		System.out.println(applicationContext);
		DaoDemo bean = applicationContext.getBean(DaoDemo.class);
		System.out.println(bean.select());
		bean = applicationContext.getBean("dao",DaoDemo.class);
		System.out.println(bean.select());
	}

	@Test
	public void testBeanManagement(){
		ServiceTest bean = applicationContext.getBean(ServiceTest.class);
		System.out.println(bean);
	}
	@Test
	public void testBeanConfig(){
		SimpleDateFormat bean = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(bean.format(new Date()));
	}
	@Autowired
	@Qualifier("dao")
	private DaoDemo daoDemo;
	@Autowired
	private ServiceTest serviceTest;
	@Autowired
	private SimpleDateFormat simpleDateFormat;
	@Test
	public void testDI(){
		System.out.println(daoDemo);
		System.out.println(serviceTest);
		System.out.println(simpleDateFormat);
	}

}
