package com.motherboard.cilentDemo.config;

import org.springframework.context.annotation.Configuration;

import io.github.xdiamond.client.spring.XDiamondConfigFactoryBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@Configuration
public class XdiamondConfig implements EnvironmentAware {

	private final static Logger LOGGER = LoggerFactory.getLogger(XdiamondConfig.class);

	private Environment environment;

	@Bean
	public XDiamondConfigFactoryBean xDiamondConfigFactoryBean() {

		XDiamondConfigFactoryBean xDiamondConfigFactoryBean = new XDiamondConfigFactoryBean();

		String groupid = environment.getProperty("xdiamond.client.groupid");
		String artifactid = environment.getProperty("xdiamond.client.artifactid");
		String version = environment.getProperty("xdiamond.client.version");
		String profile = environment.getProperty("xdiamond.client.profile");
		String secretkey = environment.getProperty("xdiamond.client.secretkey");

		String host = environment.getProperty("xdiamond.server.host");
		String port = environment.getProperty("xdiamond.server.port");

		LOGGER.info("\nXdiamondConfig: \n\t groupid=" + groupid + "\n\t artifactid=" + artifactid + "\n\t version="
				+ version + "\n\t profile=" + profile + "\n\t host=" + host + "\n\t port=" + port);

		xDiamondConfigFactoryBean.setArtifactId(artifactid);
		xDiamondConfigFactoryBean.setGroupId(groupid);
		xDiamondConfigFactoryBean.setVersion(version);
		xDiamondConfigFactoryBean.setProfile(profile);
		xDiamondConfigFactoryBean.setSecretKey(secretkey);

		xDiamondConfigFactoryBean.setServerHost(host);
		xDiamondConfigFactoryBean.setServerPort(port);

		return xDiamondConfigFactoryBean;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

}