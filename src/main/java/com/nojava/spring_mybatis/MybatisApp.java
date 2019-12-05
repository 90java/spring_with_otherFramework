package com.nojava.spring_mybatis;

import com.nojava.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisApp {

    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = sqlSessionFactory.openSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.selectStudentByid(null);
            System.out.println(student);
        }
    }


}
