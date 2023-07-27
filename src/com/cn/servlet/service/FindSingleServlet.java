package com.cn.servlet.service;

import com.cn.dao.ServiceDao;
import com.cn.dao.ServiceTypeDao;
import com.cn.enity.ServiceInfo;
import com.cn.enity.ServiceType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindSingleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        try {
            ServiceDao dao = new ServiceDao();
            ServiceTypeDao serviceTypeDao = new ServiceTypeDao();
            String id = request.getParameter("id");
            String typeId = request.getParameter("typeId");
            List<ServiceInfo> list = dao.findById(id);
            List<ServiceType> serviceTypes = serviceTypeDao.findByTypeId(typeId);
            if (list == null || serviceTypes == null) {
                throw new NullPointerException();
            }
            ServiceInfo serviceInfo = list.get(0);
            ServiceType serviceType = serviceTypes.get(0);
            request.getSession().setAttribute("serviceInfo", serviceInfo);
            request.getSession().setAttribute("serviceType", serviceType);
            request.getRequestDispatcher("WEB-INF/jsp/service/service_detail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("WEB-INF/jsp/service/service.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
