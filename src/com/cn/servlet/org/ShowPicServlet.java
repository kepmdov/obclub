package com.cn.servlet.org;

import com.cn.dao.OrgDao;
import com.cn.enity.OrgInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ShowPicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        OrgDao orgDao = new OrgDao();
        if (id != null) {
            List<OrgInfo> orgInfos = orgDao.findById(id);
            byte[] pic = orgInfos.get(0).getOrgPic();
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
