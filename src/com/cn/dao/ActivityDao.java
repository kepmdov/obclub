package com.cn.dao;

import com.cn.base.BaseDao;
import com.cn.enity.ActivityInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    public List<ActivityInfo> findAll(){
        Connection connection = BaseDao.getConnection();
        try{
            Statement statement = connection.createStatement();
            String sql= "select * from activity_info";
            ResultSet resultSet = statement.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ActivityInfo> findById(String id){
        Connection connection = BaseDao.getConnection();
        try{
            Statement statement = connection.createStatement();
            String sql= "select * from activity_info where ID="+id;
            ResultSet resultSet = statement.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ActivityInfo> getList(ResultSet resultSet){
        try {
            ArrayList<ActivityInfo> list = new ArrayList<>();
            while (resultSet.next()){
                ActivityInfo activityInfo = new ActivityInfo();
                activityInfo.setId(resultSet.getLong(1));
                activityInfo.setActTitle(resultSet.getString(2));
                activityInfo.setActExtra(resultSet.getString(3));
                activityInfo.setActDetail(resultSet.getString(4));
                activityInfo.setActPic(resultSet.getBytes(5));
                activityInfo.setActPrice(resultSet.getFloat(6));
                activityInfo.setStartDate(resultSet.getDate(7));
                activityInfo.setEndDate(resultSet.getDate(8));
                activityInfo.setCreateDate(resultSet.getDate(9));
                activityInfo.setShoworder(resultSet.getInt(10));
                activityInfo.setIfshow(resultSet.getString(11));
                list.add(activityInfo);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
