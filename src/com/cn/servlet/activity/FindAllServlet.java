package com.cn.servlet.activity;

import com.cn.base.PageUtil;
import com.cn.dao.ActivityDao;
import com.cn.enity.ActivityInfo;
import com.cn.enity.Page;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class FindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message="";
        try{
            ActivityDao dao=new ActivityDao();
            List<ActivityInfo> list=dao.findAll();
            if (list==null){
                throw new NullPointerException();
            }
            PageUtil<ActivityInfo> pageUtil = new PageUtil<>();
            Page page = pageUtil.allPage(list, 3, request);
            List<ActivityInfo> currentPagelist = pageUtil.getList(page, list);
            page.setPageSize(currentPagelist.size());
            request.setAttribute("list",list);
            request.setAttribute("activityInfos",currentPagelist);
            request.setAttribute("page",page);
            request.getRequestDispatcher("WEB-INF/jsp/activity/activity.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            message="获取资源失败";
            request.setAttribute("message",message);
            request.getRequestDispatcher("index.jsp")
                    .forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
