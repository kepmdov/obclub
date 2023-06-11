package com.cn.dao;

import com.cn.base.BaseDao;
import com.cn.enity.HouseInfo;
import com.cn.enity.JobInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobDao {
    public List<JobInfo> findAll(){
        Connection connection = BaseDao.getConnection();
        try{
            Statement statement = connection.createStatement();
            String sql= "select * from job_info";
            ResultSet resultSet = statement.executeQuery(sql);
            return getList(resultSet);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private List<JobInfo> getList(ResultSet resultSet){
        try{
            ArrayList<JobInfo> list = new ArrayList<>();
            while (resultSet.next()){
                JobInfo jobInfo = new JobInfo();
                jobInfo.setId(resultSet.getLong(1));
                jobInfo.setJobTitle(resultSet.getString(2));
                jobInfo.setJobDetail(resultSet.getString(3));
                jobInfo.setCreatedate(resultSet.getDate(4));
                jobInfo.setShoworder(resultSet.getInt(5));
                jobInfo.setIfshow(resultSet.getString(6));
                list.add(jobInfo);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
