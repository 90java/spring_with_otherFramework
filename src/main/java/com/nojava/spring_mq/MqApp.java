package com.nojava.spring_mq;

import com.nojava.spring_mq.config.AppConfig;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MqApp {
    /**
     * java配置
     */
    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConnectionFactory connectionFactory = (ConnectionFactory)context.getBean("mqConnectionFactory");
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.declareQueue(new Queue("myqueue"));
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.convertAndSend("myqueue","foo");
        String foo = (String)rabbitTemplate.receiveAndConvert("myqueue");
        System.out.println(foo);
    }

    /**
     * xml配置
     */
    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AmqpTemplate template = context.getBean(AmqpTemplate.class);
        template.convertAndSend("myqueue", "foo");
        String foo = (String) template.receiveAndConvert("myqueue");
        System.out.println(foo);
    }


}
