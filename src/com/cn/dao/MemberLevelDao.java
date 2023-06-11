package com.cn.dao;

import com.cn.base.BaseDao;
import com.cn.enity.MemberLevel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberLevelDao {

    public List<MemberLevel> findAll(){
        Connection connection = BaseDao.getConnection();
        try{
            Statement state = connection.createStatement();//容器
            String sql = "select * from member_level";
            ResultSet resultSet = state.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<MemberLevel> findById(String id) {
        Connection connection = BaseDao.getConnection();
        try {
            Statement state = connection.createStatement();//容器
            String sql = "select * from member_level where ID = " + id;
            ResultSet resultSet = state.executeQuery(sql);
            return getList(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<MemberLevel> getList(ResultSet resultSet) {
        try {
            List<MemberLevel> list = new ArrayList<>();
            while (resultSet.next()) {
                MemberLevel memberLevel = new MemberLevel();
                memberLevel.setId(resultSet.getLong(1));
                memberLevel.setLevelTitle(resultSet.getString(2));
                memberLevel.setLevelDetail(resultSet.getString(3));
                memberLevel.setLevelPic(resultSet.getBytes(4));
                list.add(memberLevel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
