package com.cn.servlet.member;

import com.cn.dao.MemberDao;
import com.cn.enity.MemberInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        String message = "";
        MemberInfo memberInfo = new MemberInfo();
        try {
            MemberDao dao = new MemberDao();
            memberInfo.setMemPassword(request.getParameter("memPassword"));
            memberInfo.setMemName(request.getParameter("memName"));
            memberInfo.setMemAge(request.getParameter("memAge"));
            memberInfo.setMemSex(request.getParameter("memSex"));
            memberInfo.setMemAddress(request.getParameter("memAddress"));
            memberInfo.setMemEmail(request.getParameter("memEmail"));
            memberInfo.setMemPhone(request.getParameter("memPhone"));
            String id = request.getParameter("id");
            memberInfo.setId(id);
            dao.update(memberInfo);
            memberInfo = dao.findById(memberInfo);
            message = "修改成功";
            request.getSession().setAttribute("memberInfo", memberInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            message = "修改失败";
        } finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}