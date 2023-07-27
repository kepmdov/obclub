package com.cn.servlet.activity;

import com.cn.dao.ActivityDao;
import com.cn.enity.ActivityInfo;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ShowPicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        ActivityDao activityDao = new ActivityDao();
        if (id!=null){
            List<ActivityInfo> activityInfos = activityDao.findById(id);
            byte[] pic = activityInfos.get(0).getActPic();
            ServletOutputStream out = response.getOutputStream();
            if (pic!=null){
                out.write(pic);
                out.flush();
                out.close();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request,response);
    }
}
