package com.nojava.domain;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "student")
@SequenceGenerator(name = "SEQ_STUDENT",sequenceName = "SEQ_STUDENT",allocationSize = 1)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_STUDENT")
    private Integer id;

//    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    private String yuliu01;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getYuliu01() {
        return yuliu01;
    }

    public void setYuliu01(String yuliu01) {
        this.yuliu01 = yuliu01;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", yuliu01='" + yuliu01 + '\'' +
                '}';
    }
}
