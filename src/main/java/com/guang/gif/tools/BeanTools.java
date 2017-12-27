package com.guang.gif.tools;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

@Service
public class BeanTools implements BeanFactoryAware {
    // Spring的bean工厂
    private static BeanFactory beanFactory;
    
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory=factory;
    }
    @SuppressWarnings("unchecked")
	public static<T> T getBean(String beanName){
           return (T) beanFactory.getBean(beanName);
    }
}
