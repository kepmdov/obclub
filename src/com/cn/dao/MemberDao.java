package com.cn.dao;

import com.cn.base.BaseDao;
import com.cn.base.Util;
import com.cn.enity.MemberInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDao {
    public void Insert(MemberInfo memberInfo) throws SQLException {
        Connection connection = BaseDao.getConnection();
        try {
            Statement state = connection.createStatement();
            String sql = "insert into member_info (MEM_USERNAME, MEM_PASSWORD, LEVEL_ID, MEM_NAME, MEM_AGE, MEM_SEX, MEM_ADDRESS, MEM_TEL, MEM_PHONE, MEM_EMAIL, REG_TIME, CARD_NO, STATUS, MEM_SCORE,MEM_PIC) value ('" +
                    memberInfo.getMemUsername() + "','" +
                    memberInfo.getMemPassword() + "','" +
                    memberInfo.getMemberLevel().getId() + "','" +
                    memberInfo.getMemName() + "','" +
                    memberInfo.getMemAge() + "','" +
                    memberInfo.getMemSex() + "','" +
                    memberInfo.getMemAddress() + "','" +
                    memberInfo.getMemTel() + "','" +
                    memberInfo.getMemPhone() + "','" +
                    memberInfo.getMemEmail() + "','" +
                    Util.changeDate(memberInfo.getRegTime()) + "','" +
                    memberInfo.getCardNo() + "','" +
                    memberInfo.getStatus() + "','" +
                    memberInfo.getMemScore() + "','" +
                    memberInfo.getMemPic() + "')";
            state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            connection.close();
        }
    }

    public void update(MemberInfo memberInfo) throws SQLException {
        Connection connection = BaseDao.getConnection();
        try {
            Statement state = connection.createStatement();
            String sql = "update member_info set MEM_NAME='" +
                    memberInfo.getMemName() + "',MEM_AGE='" +
                    memberInfo.getMemAge() + "',MEM_SEX='" +
                    memberInfo.getMemSex() + "',MEM_ADDRESS='" +
                    memberInfo.getMemAddress() + "',MEM_EMAIL='" +
                    memberInfo.getMemEmail() + "',MEM_PHONE='" +
                    memberInfo.getMemPhone() + "',MEM_PASSWORD='" +
                    memberInfo.getMemPassword() + "' where ID='" +
                    memberInfo.getId() + "'";
            state.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            connection.close();
        }
    }

    public MemberInfo findByName(MemberInfo memberInfo) throws SQLException {
        Connection connection = BaseDao.getConnection();
        try {
            Statement state = connection.createStatement();
            String sql = "select * from member_info where MEM_USERNAME = '" +
                    memberInfo.getMemUsername() + "'";
            ResultSet resultSet = state.executeQuery(sql);
            memberInfo = getList(resultSet);
            connection.close();
            return memberInfo;
        } catch (Exception e) {
            throw e;
        }
    }

    public MemberInfo findById(MemberInfo memberInfo) throws SQLException {
        Connection connection = BaseDao.getConnection();
        try {
            Statement state = connection.createStatement();//容器
            String sql = "select * from member_info where ID = '" +
                    memberInfo.getId() + "'";
            ResultSet rs = state.executeQuery(sql);
            memberInfo = getList(rs);
            connection.close();
            return memberInfo;
        } catch (Exception e) {
            throw e;
        }
    }

    public MemberInfo getList(ResultSet rs) throws SQLException {
        MemberInfo memberInfo = new MemberInfo();
        while (rs.next()) {
            memberInfo.setId(rs.getString(1));
            memberInfo.setMemUsername(rs.getString(2));
            memberInfo.setMemPassword(rs.getString(3));
            memberInfo.setMemName(rs.getString(5));
            memberInfo.setMemAge(rs.getString(6));
            memberInfo.setMemSex(rs.getString(7));
            memberInfo.setMemAddress(rs.getString(8));
            memberInfo.setMemPhone(rs.getString(10));
            memberInfo.setMemEmail(rs.getString(11));
        }
        return memberInfo;
    }
}
