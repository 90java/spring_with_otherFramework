package com.nojava.spring_mybatis;

import com.nojava.domain.Student;
import com.nojava.spring_mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MybatisApp {

    private static String resource = "mybatis-config.xml";

    private SqlSessionFactory sqlSessionFactory;



    /**
     * 创建sqlSessionFactory工厂类
     * @throws IOException
     */
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 测试工厂类产生不同的SqlSession对象
     */
    @Test
    public void test01(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        SqlSession sqlSession4 = sqlSessionFactory.openSession();
        SqlSession sqlSession5 = sqlSessionFactory.openSession();

        System.out.println("sqlSession1:"+sqlSession1);
        System.out.println("sqlSession2:"+sqlSession2);
        System.out.println("sqlSession3:"+sqlSession3);
        System.out.println("sqlSession4:"+sqlSession4);
        System.out.println("sqlSession5:"+sqlSession5);

    }

    /**
     * 测试查询方法
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.selectStudentByid(5);
            System.out.println(student.getYuliu01()==null);
            System.out.println(student);
        }
    }

    /**
     * 测试插入方法
     * openSession() 默认不自动提交事务 所以执行dml后需要手动提交事务session.commit();
     * 如果想手动设置提交事务openSession(true)
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        //操作实体
        Student student = new Student();
//        student.setId(16);
        student.setName("lixiaofeng13131313");
        student.setGender("m");
        student.setAge(13);
        student.setEmail(UUID.randomUUID().toString().replaceAll("-","")+"@qq.com");
        student.setBirthday(new Date());
        student.setYuliu01("yuliu01");
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            boolean b = mapper.insertStudent(student);
            System.out.println(b);
//            session.commit();
        }
    }

    /**
     * 查询所有的结果
     */
    @Test
    public void test04(){
        try(SqlSession session = sqlSessionFactory.openSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> students = mapper.findAllStudents();
            System.out.println(students);
        }
    }

    /**
     *
     * 执行sql语句的方式  执行调用XxxxMapper.xml中写好的sql语句 不用定义接口
     */
    @Test
    public void test05(){
        try(SqlSession session = sqlSessionFactory.openSession()){
            Student o = (Student)session.selectOne("com.nojava.spring_mybatis.mapper.StudentMapper.selectStudentByid", 3);
            System.out.println(o);
        }
    }

    /**
     * 多环境测试
     */
    @Test
    public void test06() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream,"test");
        //操作实体
        Student student = new Student();
//        student.setId(16);
        student.setName("lixiaofeng13131313");
        student.setGender("m");
        student.setAge(13);
        student.setEmail(UUID.randomUUID().toString().replaceAll("-","")+"@qq.com");
        student.setBirthday(new Date());
        student.setYuliu01("yuliu01");
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            boolean b = mapper.insertStudent(student);
            System.out.println(b);
//            session.commit();
        }
    }

    /**
     * db.properties 配置测试
     * Oracle并不支持AUTO_INCREMENT列 测试其使用序列（SEQUENCE）来生成主键值
     *
     */
    @Test
    public void test07() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream,"dev01");
        //操作实体
        Student student = new Student();
//        student.setId(16);
        student.setName("lixiaofeng13131313");
        student.setGender("m");
        student.setAge(13);
        student.setEmail(UUID.randomUUID().toString().replaceAll("-","")+"@qq.com");
        student.setBirthday(new Date());
        student.setYuliu01("yuliu01");
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            boolean b = mapper.insertStudent02(student);
            System.out.println(b);
//            session.commit();
        }
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void test08() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream,"dev01");

        try(SqlSession session = sqlSessionFactory.openSession(true)){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> allStudents = mapper.findAllStudents();
            System.out.println(allStudents);
        }
    }

}
