package com.cn.servlet.house;

import com.cn.dao.HouseDao;
import com.cn.enity.HouseInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindSingleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message="";
        try{
            String id=req.getParameter("id");
            HouseDao dao = new HouseDao();
            List<HouseInfo> houseInfos = dao.findById(id);
            if (houseInfos==null){
                throw new NullPointerException();
            }
            HouseInfo houseInfo = houseInfos.get(0);
            req.getSession().setAttribute("houseInfo",houseInfo);
            req.getRequestDispatcher("WEB-INF/jsp/house/house_detail.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            message="获取资源失败";
            req.setAttribute("message",message);
            req.getRequestDispatcher("WEB-INF/jsp/house/house.jsp").forward(req,resp);
        }
    }
}
