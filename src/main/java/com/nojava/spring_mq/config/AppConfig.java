package com.nojava.spring_mq.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:rabbitmq.properties")
@ComponentScan("com.nojava")
public class AppConfig {

    @Value("${mymq.username}")
    private String username;

    @Value("${mymq.password}")
    private String password;

    @Value("${mymq.host}")
    private String host;

    @Value("${mymq.port}")
    private int port;

    @Value("${mymq.vhost}")
    private String virtualHost;

    @Bean("mqConnectionFactory")
    public ConnectionFactory getConnection(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setHost(host);
        cachingConnectionFactory.setPort(port);
        cachingConnectionFactory.setVirtualHost(virtualHost);
        return cachingConnectionFactory;
    }

}
