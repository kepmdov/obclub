package com.test.base;

import com.cn.base.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDaoTest {
    public static void main(String[] args) throws Exception {
        Connection connection = BaseDao.getConnection();
        Statement statement = connection.createStatement();
        String sql="select * from house_info";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }
}
