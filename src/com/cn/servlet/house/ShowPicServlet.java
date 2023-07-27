package com.cn.servlet.house;

import com.cn.dao.HouseDao;
import com.cn.enity.HouseInfo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ShowPicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        HouseDao houseDao = new HouseDao();
        if (id != null) {
            List<HouseInfo> houseInfos = houseDao.findById(id);
            byte[] pic = houseInfos.get(0).getHousePic();
            OutputStream outs = resp.getOutputStream();
            if (pic != null) {
                outs.write(pic);
                outs.flush();
                outs.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }
}
