package com.nojava.spring_mybatis.mapper;

import com.nojava.domain.Student;

import java.util.List;

public interface StudentMapper {

   Student selectStudentByid(Integer id);

   boolean insertStudent(Student student);

   boolean insertStudent02(Student student);

   List<Student> findAllStudents();

}
