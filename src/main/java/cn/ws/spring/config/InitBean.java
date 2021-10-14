package cn.ws.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InitBean implements BeanDefinitionRegistryPostProcessor, InitializingBean
{


	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException
	{
		System.out.println("====================================================================================================在Bean对象初始化之前");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException
	{
		System.out.println("====================================================================================================在Bean对象初始化之前2");
	}

	@Override
	public void afterPropertiesSet()
	{
		System.out.println("====================================================================================================在Bean对象初始化完之后");
	}
}