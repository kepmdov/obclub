package com.cn.dao;

import com.cn.base.BaseDao;
import com.cn.enity.OrgInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrgDao {

    public List<OrgInfo> findAll(){
        Connection connection = BaseDao.getConnection();
        try{
            Statement state = connection.createStatement();//容器
            String sql = "select * from org_info";
            ResultSet resultSet = state.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<OrgInfo> findById(String id){
        Connection connection = BaseDao.getConnection();
        try{
            Statement state=connection.createStatement();//容器
            String sql = "select * from org_info where ID = " + id ;
            ResultSet resultSet = state.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private List<OrgInfo> getList(ResultSet resultSet){
        try {
            List<OrgInfo> list = new ArrayList<>();
            while (resultSet.next()){
                OrgInfo orgInfo = new OrgInfo();
                orgInfo.setId(resultSet.getLong(1));
                orgInfo.setOrgTitle(resultSet.getString(2));
                orgInfo.setOrgbDetail(resultSet.getString(3));
                orgInfo.setOrgPic(resultSet.getBytes(4));
                orgInfo.setCreatedate(resultSet.getDate(5));
                orgInfo.setShoworder(resultSet.getInt(6));
                orgInfo.setIfshow(resultSet.getString(7));
                list.add(orgInfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
