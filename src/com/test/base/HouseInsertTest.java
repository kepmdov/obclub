package com.test.base;

import com.cn.base.BaseDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HouseInsertTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = BaseDao.getConnection();
        String sql="update house_info set HOUSE_PIC = ? where ID=10;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        byte[] file =file2Byte("D:\\kt.jpg");
        preparedStatement.setBytes(1,file);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        preparedStatement.close();
        connection.close();
    }
    public static byte[] file2Byte(String inFile){
        InputStream in = null;
        try {
            in = new FileInputStream(new File(inFile));

            int len = in.available();
            byte [] result = new byte[len];
            in.read(result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
