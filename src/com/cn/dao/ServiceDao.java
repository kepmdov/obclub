package com.cn.dao;

import com.cn.base.BaseDao;
import com.cn.enity.ServiceInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao {

    public List<ServiceInfo> findAll(){
        Connection connection = BaseDao.getConnection();
        try{
            Statement state = connection.createStatement();
            String sql = "select * from service_info";
            ResultSet resultSet = state.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ServiceInfo> findById(String id){
        Connection connection = BaseDao.getConnection();
        try{
            Statement state=connection.createStatement();//容器
            String sql = "select * from service_info where ID = " + id ;
            ResultSet resultSet = state.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private List<ServiceInfo> getList(ResultSet resultSet) {
        try {
            List<ServiceInfo> list = new ArrayList<>();
            while (resultSet.next()) {
                ServiceInfo serviceInfo = new ServiceInfo();
                serviceInfo.setId(resultSet.getLong(1));
                serviceInfo.setServiceType(resultSet.getLong(2));
                serviceInfo.setSerTitle(resultSet.getString(3));
                serviceInfo.setSerDetail(resultSet.getString(4));
                serviceInfo.setSerPic(resultSet.getBytes(5));
                serviceInfo.setCreatedate(resultSet.getDate(6));
                serviceInfo.setShoworder(resultSet.getInt(7));
                serviceInfo.setIfshow(resultSet.getString(8));
                list.add(serviceInfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
