package com.chen.springbootmybatisdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidDBConfig implements EnvironmentAware {
    private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);

    private Environment environment;

    private String getStringProperty(String propertyName) {
        String property = environment.getProperty(propertyName, "");
        return property;
    }

    private Integer getIntProperty(String propertyName) {
        String property = environment.getProperty(propertyName, "");
        Integer value = Integer.valueOf(property);
        try {
            value = Integer.valueOf(property);

        } catch (NumberFormatException e) {
            logger.error("get int property - " + propertyName + " failed", e);
        }
        return value;
    }

    private Boolean getBooleanProperty(String propertyName) {
        String property = environment.getProperty(propertyName, "");
        Boolean aBoolean = Boolean.valueOf(property);
        return aBoolean;
    }


    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        String url = environment.getProperty("spring.datasource.url");

        datasource.setUrl(url);
        datasource.setUsername(environment.getProperty("spring.datasource.username"));
        datasource.setPassword(getStringProperty("spring.datasource.password"));
        datasource.setDriverClassName(getStringProperty("spring.datasource.driverClassName"));
        //configuration
        datasource.setInitialSize(getIntProperty("spring.datasource.initialSize"));
        datasource.setMinIdle(getIntProperty("spring.datasource.minIdle"));
        datasource.setMaxActive(getIntProperty("spring.datasource.maxActive"));
        datasource.setMaxWait(getIntProperty("spring.datasource.maxWait"));
        datasource.setTimeBetweenEvictionRunsMillis(getIntProperty("spring.datasource.timeBetweenEvictionRunsMillis"));
        datasource.setMinEvictableIdleTimeMillis(getIntProperty("spring.datasource.minEvictableIdleTimeMillis"));
        datasource.setValidationQuery(getStringProperty("spring.datasource.validationQuery"));
        datasource.setTestWhileIdle(getBooleanProperty("spring.datasource.testWhileIdle"));
        datasource.setTestOnBorrow(getBooleanProperty("spring.datasource.testOnBorrow"));
        datasource.setTestOnReturn(getBooleanProperty("spring.datasource.testOnReturn"));
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(getStringProperty("${spring.datasource.filters}"));
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter : {0}", e);
        }
//        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}