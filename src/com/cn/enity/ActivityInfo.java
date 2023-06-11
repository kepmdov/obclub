package com.cn.enity;

import java.util.Arrays;
import java.util.Date;

public class ActivityInfo {
    private Long id;
    private String actTitle;
    private String actExtra;
    private String actDetail;
    private byte[] actPic;
    private Float actPrice;
    private Date startDate;
    private Date endDate;
    private Date createDate;
    private Integer showorder;
    private String ifshow;


    public ActivityInfo() {
    }

    public ActivityInfo(String actTitle, Date createDate, Integer showorder, String ifshow) {
        this.actTitle = actTitle;
        this.createDate = createDate;
        this.showorder = showorder;
        this.ifshow = ifshow;
    }

    public ActivityInfo(String actTitle, String actExtra, String actDetail, byte[] actPic,
                        Float actPrice, Date startDate, Date endDate, Date createDate,
                        Integer showorder, String ifshow) {
        this.actTitle = actTitle;
        this.actExtra = actExtra;
        this.actDetail = actDetail;
        this.actPic = actPic;
        this.actPrice = actPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDate = createDate;
        this.showorder = showorder;
        this.ifshow = ifshow;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getActTitle() {
        return actTitle;
    }
    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }
    public String getActExtra() {
        return actExtra;
    }
    public void setActExtra(String actExtra) {
        this.actExtra = actExtra;
    }
    public String getActDetail() {
        return actDetail;
    }
    public void setActDetail(String actDetail) {
        this.actDetail = actDetail;
    }
    public byte[] getActPic() {
        return actPic;
    }
    public void setActPic(byte[] actPic) {
        this.actPic = actPic;
    }
    public Float getActPrice() {
        return actPrice;
    }
    public void setActPrice(Float actPrice) {
        this.actPrice = actPrice;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Integer getShoworder() {
        return showorder;
    }
    public void setShoworder(Integer showorder) {
        this.showorder = showorder;
    }
    public String getIfshow() {
        return ifshow;
    }
    public void setIfshow(String ifshow) {
        this.ifshow = ifshow;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "ActivityInfo{" +
                "id=" + id +
                ", actTitle='" + actTitle + '\'' +
                ", actExtra='" + actExtra + '\'' +
                ", actDetail='" + actDetail + '\'' +
                ", actPic=" + Arrays.toString(actPic) +
                ", actPrice=" + actPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createDate=" + createDate +
                ", showorder=" + showorder +
                ", ifshow='" + ifshow + '\'' +
                '}';
    }
}
