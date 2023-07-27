package com.cn.servlet.service;

import com.cn.dao.ServiceDao;
import com.cn.enity.ServiceInfo;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ShowPicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ServiceDao serviceDao = new ServiceDao();
        if (id != null) {
            List<ServiceInfo> serviceInfos = serviceDao.findById(id);
            byte[] pic = serviceInfos.get(0).getSerPic();
            OutputStream outs = response.getOutputStream();
            if (pic != null) {
                outs.write(pic);
                outs.flush();
                outs.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
