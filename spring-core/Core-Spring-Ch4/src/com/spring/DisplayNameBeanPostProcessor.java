package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor {
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Inside postProcessBeforeInitialization:: Bean Name: "+beanName+" Object: "+bean);
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Inside postProcessAfterInitialization:: Bean Name: "+beanName+" Object: "+bean);
		return bean;
	}

}
