package com.cn.dao;

import com.cn.base.BaseDao;
import com.cn.enity.ActivityInfo;
import com.cn.enity.HouseInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HouseDao {
    public List<HouseInfo> findAll(){
        Connection connection = BaseDao.getConnection();
        try{
            Statement statement = connection.createStatement();
            String sql= "select * from house_info";
            ResultSet resultSet = statement.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<HouseInfo> findById(String id){
        Connection connection = BaseDao.getConnection();
        try{
            Statement statement = connection.createStatement();
            String sql= "select * from house_info where ID="+id;
            ResultSet resultSet = statement.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private List<HouseInfo> getList(ResultSet resultSet){
        try{
            ArrayList<HouseInfo> list = new ArrayList<>();
            while (resultSet.next()){
                HouseInfo houseInfo = new HouseInfo();
                houseInfo.setId(resultSet.getLong(1));
                houseInfo.setHouseTitle(resultSet.getString(2));
                houseInfo.setHousePrice(resultSet.getFloat(3));
                houseInfo.setHouseDetail(resultSet.getString(4));
                houseInfo.setHousePic(resultSet.getBytes(5));
                houseInfo.setCreateDate(resultSet.getDate(6));
                houseInfo.setShoworder(resultSet.getInt(7));
                houseInfo.setIfshow(resultSet.getString(8));
                list.add(houseInfo);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
