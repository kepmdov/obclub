package com.cn.base;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
    public static Connection getConnection(){
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/obclub?useSSL=true&useU" +
                "`nicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String user="root";
        String password="123456";
        Connection connection=null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
