package com.motherboard.cilentDemo.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


public class LoadAdditionPropertiesListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	private final static Logger LOGGER = LoggerFactory.getLogger(LoadAdditionPropertiesListener.class);
	
	private ResourceLoader loader = new DefaultResourceLoader();

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

		Resource resource = loader.getResource("classpath:xdiamond.yml");
		LOGGER.info("getResource from xdiamond.yml");
		PropertySource<?> propertySource;
		try {
			propertySource = new PropertySourcesLoader().load(resource);
			event.getEnvironment().getPropertySources().addLast(propertySource);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

	}

}
