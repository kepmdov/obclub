package com.cn.servlet.activity;

import com.cn.dao.ActivityDao;
import com.cn.enity.ActivityInfo;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class FindSingleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message="";
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        try{
            ActivityDao dao = new ActivityDao();
            String id = request.getParameter("id");
            List<ActivityInfo> list = dao.findById(id);
            if (list==null){
                throw new NullPointerException();
            }
            ActivityInfo act = list.get(0);
            request.getSession().setAttribute("activity",act);
            request.getRequestDispatcher("WEB-INF/jsp/activity/activity_detail.jsp")
                    .forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            message="获取资源失败";
            request.setAttribute("message",message);
            request.getRequestDispatcher("WEB-INF/jsp/activity/activity.jsp")
                    .forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request,response);
    }
}
