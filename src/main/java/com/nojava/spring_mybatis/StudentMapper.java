package com.nojava.spring_mybatis;

import com.nojava.domain.Student;

import java.util.List;

public interface StudentMapper {

   Student selectStudentByid(Integer id);

   boolean insertStudent(Student student);

   List<Student> findAllStudents();

}
