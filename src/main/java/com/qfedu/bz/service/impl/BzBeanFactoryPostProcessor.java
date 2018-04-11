package com.qfedu.bz.service.impl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BzBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	private final static Logger LOG = LogManager.getLogger(BzBeanFactoryPostProcessor.class);

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// 如果BzUserExtensionService没有@Primary注解，此处需要设置
		BeanDefinition bf = beanFactory.getBeanDefinition("bzUserExtensionService");
		// bf.setPrimary(true);
	}
}
