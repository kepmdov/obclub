package com.cn.servlet.house;

import com.cn.base.PageUtil;
import com.cn.dao.HouseDao;
import com.cn.enity.HouseInfo;
import com.cn.enity.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class FindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message="";
        try{
            HouseDao dao = new HouseDao();
            List<HouseInfo> list = dao.findAll();
            if (list==null){
                throw new NullPointerException();
            }
            PageUtil<HouseInfo> pageUtil = new PageUtil<>();
            Page page = pageUtil.allPage(list, 10, req);
            List<HouseInfo> currentPageList = pageUtil.getList(page, list);
            page.setPageSize(currentPageList.size());
            req.getSession().setAttribute("list",list);
            req.setAttribute("houseInfos",currentPageList);
            req.setAttribute("page",page);
            req.getRequestDispatcher("WEB-INF/jsp/house/house.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            message="获取资源失败";
            req.setAttribute("message",message);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
