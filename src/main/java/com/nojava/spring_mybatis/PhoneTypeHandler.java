package com.nojava.spring_mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

    //遇到PhoneNumber参数的时候应该如何在ps中设置值
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PhoneNumber phoneNumber, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,phoneNumber.getAsString());
    }
    //查询中遇到PhoneNumber类型的应该如何封装(使用列名封装)
    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return new PhoneNumber(resultSet.getString(s));
    }
    //查询中遇到PhoneNumber类型的应该如何封装(使用列的下标)
    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new PhoneNumber(resultSet.getString(i));
    }
    //CallableStatement使用中遇到了PhoneNumber类型的应该如何封装
    @Override
    public PhoneNumber getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new PhoneNumber(callableStatement.getString(i));
    }
}
