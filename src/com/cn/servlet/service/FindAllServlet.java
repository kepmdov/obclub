package com.cn.servlet.service;

import com.cn.base.PageUtil;
import com.cn.dao.ServiceDao;
import com.cn.dao.ServiceTypeDao;
import com.cn.enity.Page;
import com.cn.enity.ServiceInfo;
import com.cn.enity.ServiceType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        try {
            ServiceDao dao = new ServiceDao();
            ServiceTypeDao serviceTypeDao = new ServiceTypeDao();
            List<ServiceInfo> serviceInfos = dao.findAll();
            List<ServiceType> serviceTypes = serviceTypeDao.findTypeAll();
            PageUtil<ServiceInfo> pageUtil = new PageUtil<>();
            if (serviceTypes == null || serviceInfos == null) {
                throw new NullPointerException();
            }
            Page page = pageUtil.allPage(serviceInfos, 6, request);
            List<ServiceInfo> currentPagelist = pageUtil.getList(page, serviceInfos);
            page.setPageSize(currentPagelist.size());
            request.setAttribute("Page", page);
            request.setAttribute("serviceInfos", currentPagelist);
            request.setAttribute("serviceTypes", serviceTypes);
            request.getRequestDispatcher("WEB-INF/jsp/service/service.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
