package com.cn.servlet.org;

import com.cn.dao.OrgDao;
import com.cn.enity.OrgInfo;

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
            String id = request.getParameter("id");
            OrgDao dao = new OrgDao();
            List<OrgInfo> orgInfos = dao.findById(id);
            if (orgInfos == null) {
                throw new NullPointerException();
            }
            OrgInfo orgInfo = orgInfos.get(0);
            request.getSession().setAttribute("orgInfo", orgInfo);
            request.getRequestDispatcher("WEB-INF/jsp/org/org_detail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("WEB-INF/jsp/org/org.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
