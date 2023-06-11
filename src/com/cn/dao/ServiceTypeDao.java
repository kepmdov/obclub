package com.cn.dao;

import com.cn.base.BaseDao;
import com.cn.enity.ServiceType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDao {

    public List<ServiceType> findTypeAll(){
        Connection connection = BaseDao.getConnection();
        try{
            Statement state = connection.createStatement();//容器
            String sql = "select * from service_type";
            ResultSet resultSet = state.executeQuery(sql);
            return getTypeList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ServiceType> findByTypeId(String id){
        Connection connection = BaseDao.getConnection();
        try{
            Statement state=connection.createStatement();//容器
            String sql = "select * from service_type where ID = " + id ;
            ResultSet resultSet = state.executeQuery(sql);
            return getTypeList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    private List<ServiceType> getTypeList(ResultSet resultSet) {
        List<ServiceType> result;
        try {
            List<ServiceType> list = new ArrayList<>();
            while (resultSet.next()) {
                ServiceType serviceType = new ServiceType();
                serviceType.setId(resultSet.getLong(1));
                serviceType.setTypeTitle(resultSet.getString(2));
                serviceType.setCreatedate(resultSet.getDate(3));
                serviceType.setShoworder(resultSet.getInt(4));
                serviceType.setIfshow(resultSet.getString(5));
                list.add(serviceType);
            }
            result = list;
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }
}
