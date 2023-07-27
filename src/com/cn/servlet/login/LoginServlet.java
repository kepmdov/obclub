package com.cn.servlet.login;

import com.cn.dao.ActivityDao;
import com.cn.dao.HouseDao;
import com.cn.dao.MemberDao;
import com.cn.dao.ServiceDao;
import com.cn.enity.ActivityInfo;
import com.cn.enity.HouseInfo;
import com.cn.enity.MemberInfo;
import com.cn.enity.ServiceInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        try {
            HouseDao housedao = new HouseDao();
            ServiceDao serviceDao = new ServiceDao();
            ActivityDao activityDao = new ActivityDao();
            List<HouseInfo> houseInfos = housedao.findAll();
            List<ServiceInfo> serviceInfos = serviceDao.findAll();
            List<ActivityInfo> activityInfos = activityDao.findAll();
            if (houseInfos != null && serviceInfos != null && activityInfos != null) {
                request.getSession().setAttribute("houseInfos", houseInfos);
                request.getSession().setAttribute("serviceInfos", serviceInfos);
                request.getSession().setAttribute("activityInfos", activityInfos);
            }
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username == null || password == null) {
                throw new NullPointerException();
            }
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemUsername(username);
            MemberDao dao = new MemberDao();
            memberInfo = dao.findByName(memberInfo);
            if (memberInfo.getId() != null) {
                if (memberInfo.getMemPassword().equals(password)) {
                    request.getSession().setAttribute("memberInfo", memberInfo);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    message = "登录失败";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                message = "用户不存在";
                request.setAttribute("message", message);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
