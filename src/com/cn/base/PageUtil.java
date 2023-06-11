package com.cn.base;

import com.cn.enity.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;

public class PageUtil<T> {
    private int showPage(int pageSize, int listSize){
        return (listSize/pageSize==0)?(listSize/pageSize):(listSize/pageSize+1);
    }

    private int pageStart(int pageSize, int pageCurrent){
        return pageCurrent*pageSize-pageSize;
    }


    public List<T> getList(Page page, List<T> list){
        List<T> arrayList = new ArrayList<>();
        if (page.getPageCurrent()>0){
            int pageStart=pageStart(page.getPageSize(),page.getPageCurrent());
            for (int i=page.getPageSize();i>0;i--,pageStart++){
                if (pageStart<list.size()){
                    arrayList.add(list.get(pageStart));
                }
            }
            return arrayList;
        }
        return null;
    }

    private int getPageCurrent(HttpServletRequest request){
        String pageCurrent = request.getParameter("pageCurrent");
        if(pageCurrent!=null){
            return Integer.parseInt(request.getParameter("pageCurrent"));
        }
        return 1;
    }

    public Page allPage(List<T> list, int pageSize, HttpServletRequest request){
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setPageTotal(showPage(pageSize, list.size()));
        page.setPageCurrent(getPageCurrent(request));
        return page;
    }
}
