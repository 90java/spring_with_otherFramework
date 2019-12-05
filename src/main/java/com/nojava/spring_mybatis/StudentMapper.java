package com.nojava.spring_mybatis;

import com.nojava.domain.Student;

public interface StudentMapper {

   Student selectStudentByid(Integer id);

}
