package com.cn.servlet.org;

import com.cn.base.PageUtil;
import com.cn.dao.OrgDao;
import com.cn.enity.OrgInfo;
import com.cn.enity.Page;
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
            OrgDao dao = new OrgDao();
            List<OrgInfo> list = dao.findAll();
            PageUtil<OrgInfo> pageUtil = new PageUtil<>();
            if (list == null) {
                throw new NullPointerException();
            }
            Page page = pageUtil.allPage(list, 6, request);
            List<OrgInfo> currentPagelist = pageUtil.getList(page, list);
            page.setPageSize(currentPagelist.size());
            request.getSession().setAttribute("list", list);
            request.getSession().setAttribute("orgInfos", currentPagelist);
            request.getSession().setAttribute("Page", page);
            request.getRequestDispatcher("WEB-INF/jsp/org/org.jsp").forward(request, response);
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
