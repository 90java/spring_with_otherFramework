package com.nojava.spring_hibernate;

import com.nojava.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class HbnApp {

    /**
     * xml配置 /注解
     */
    @Test
    public void test01(){
        //操作实体
        Student student = new Student();
//        student.setId(16);
        student.setName("lixiaofeng13131313");
        student.setGender("m");
        student.setAge(13);
        student.setEmail(UUID.randomUUID().toString().replaceAll("-","")+"@qq.com");
        student.setBirthday(new Date());
        System.out.println("----");
        // 1.首先我们创建加载配置文件管理对象
        Configuration configuration = new Configuration();
        // 加载配置文件，默认加载src/hibernate.hbm.xml 看源码可以看出
        configuration.configure();
        // 2.创建session工厂对象 SessionFactory由configuration对象产生不可变的对象
        SessionFactory buildSessionFactory = configuration.buildSessionFactory();
        // 创建session（代表一个会话，与数据库连接的会话） SessionFactory是Session的工厂
        Session session = buildSessionFactory.openSession();
        // 开启事务  session是Transaction的工厂
        Transaction tx = session.beginTransaction();
        // 执行crud
//        session.save(student);
        session.saveOrUpdate(student);
        // 提交事务
        tx.commit();
        // 关闭session 和工厂
        session.close();
        buildSessionFactory.close();
    }

    /**
     *
     */
    @Test
    public void test02(){
        // 1.首先我们创建加载配置文件管理对象
        Configuration configuration = new Configuration();
        // 加载配置文件，默认加载src/hibernate.hbm.xml 看源码可以看出
        configuration.configure();
        // 2.创建session工厂对象 SessionFactory由configuration对象产生不可变的对象
        SessionFactory buildSessionFactory = configuration.buildSessionFactory();
        // 创建session（代表一个会话，与数据库连接的会话） SessionFactory是Session的工厂
        Session session = buildSessionFactory.openSession();

        Student student = session.get(Student.class, 13);
        System.out.println("student:"+student);

        session.close();
        buildSessionFactory.close();
    }


}
