package com.cn.servlet.member;

import com.cn.dao.MemberLevelDao;
import com.cn.enity.MemberLevel;

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
        MemberLevelDao memberLevelDao = new MemberLevelDao();
        if (id != null) {
            List<MemberLevel> memberLevelList = memberLevelDao.findById(id);
            byte[] pic = memberLevelList.get(0).getLevelPic();
            OutputStream outs = response.getOutputStream();
            if (pic != null) {
                outs.write(pic);
                outs.flush();
                outs.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
