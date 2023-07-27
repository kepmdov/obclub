package com.cn.servlet.member;

import com.cn.dao.MemberLevelDao;
import com.cn.enity.MemberLevel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class MemberLevelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        try {
            MemberLevelDao dao = new MemberLevelDao();
            List<MemberLevel> memberLevels = dao.findAll();
            if (memberLevels == null) {
                throw new NullPointerException();
            }
            request.getSession().setAttribute("memberLevels", memberLevels);
            request.getRequestDispatcher("WEB-INF/jsp/member/member.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
}
