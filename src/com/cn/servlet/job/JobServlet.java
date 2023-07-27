package com.cn.servlet.job;

import com.cn.dao.JobDao;
import com.cn.enity.JobInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class JobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        try {
            JobDao dao = new JobDao();
            List<JobInfo> jobInfos = dao.findAll();
            if (jobInfos == null) {
                throw new NullPointerException();
            }
            request.getSession().setAttribute("jobInfos", jobInfos);
            request.getRequestDispatcher("WEB-INF/jsp/job/job.jsp").forward(request, response);
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
