package com.project.oldCare.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class StringToListHandler implements TypeHandler<List<String>> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, List<String> list, JdbcType jdbcType) throws SQLException {
        if (list == null) {
            preparedStatement.setString(i, null);
        } else {
            String joinedString = String.join(",", list);
            preparedStatement.setString(i, joinedString);
        }
    }

    @Override
    public List<String> getResult(ResultSet resultSet, String s) throws SQLException {
        String resultString = resultSet.getString(s);
        return Arrays.asList(resultString.split(","));
    }

    @Override
    public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
        String resultString = resultSet.getString(i);
        return Arrays.asList(resultString.split(","));
    }

    @Override
    public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
        String resultString = callableStatement.getString(i);
        return Arrays.asList(resultString.split(","));
    }
}
