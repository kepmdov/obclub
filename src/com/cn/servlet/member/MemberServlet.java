package com.cn.servlet.member;

import com.cn.base.Util;
import com.cn.dao.MemberDao;
import com.cn.enity.MemberInfo;
import com.cn.enity.MemberLevel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MemberServlet extends HttpServlet {
    String message = "";
    private File[] uploadPic;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        try {
            String username = request.getParameter("username");
            if (username != null) {
                MemberInfo memberInfo = new MemberInfo();
                memberInfo.setMemUsername(username);
                MemberDao dao = new MemberDao();
                memberInfo = dao.findByName(memberInfo);
                if (memberInfo == null) {
                    throw new NullPointerException();
                }
                request.getSession().setAttribute("memberInfo", memberInfo);

                request.getRequestDispatcher("WEB-INF/jsp/user/user.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "资源获取失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        try {
            MemberDao dao = new MemberDao();
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemPassword(request.getParameter("memPassword"));
            memberInfo.setMemName(request.getParameter("memName"));
            memberInfo.setMemAge(request.getParameter("memAge"));
            memberInfo.setMemSex(request.getParameter("memSex"));
            memberInfo.setMemAddress(request.getParameter("memAddress"));
            memberInfo.setMemEmail(request.getParameter("memEmail"));
            memberInfo.setMemPhone(request.getParameter("memPhone"));
            memberInfo.setMemUsername(request.getParameter("memUsername"));
            memberInfo.setMemberLevel(new MemberLevel(new Long(1)));
            Date currentTime = new Date();
            memberInfo.setRegTime(currentTime);
            memberInfo.setMemScore((float) 0);
            if (uploadPic != null) {
                memberInfo.setMemPic(Util.file2byte(uploadPic[0]));
            }
            if (dao.findByName(memberInfo).getId() == null) {
                dao.Insert(memberInfo);
                message = "注册成功";
            } else {
                message = "用户已存在";
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "操作失败";
        } finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
