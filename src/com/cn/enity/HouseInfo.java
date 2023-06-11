package com.cn.enity;

import java.util.Arrays;
import java.util.Date;

public class HouseInfo {
    private Long id;
    private String houseTitle;
    private Float housePrice;
    private String houseDetail;
    private byte[] housePic;
    private Date createDate;
    private Integer showorder;
    private String ifshow;

    public HouseInfo() {
    }

    public HouseInfo(String houseTitle, Date createDate, Integer showorder, String ifshow) {
        this.houseTitle = houseTitle;
        this.createDate = createDate;
        this.showorder = showorder;
        this.ifshow = ifshow;
    }

    public HouseInfo(String houseTitle, Float housePrice, String houseDetail, byte[] housePic, Date createDate, Integer showorder, String ifshow) {
        this.houseTitle = houseTitle;
        this.housePrice = housePrice;
        this.houseDetail = houseDetail;
        this.housePic = housePic;
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

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public Float getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(Float housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseDetail() {
        return houseDetail;
    }

    public void setHouseDetail(String houseDetail) {
        this.houseDetail = houseDetail;
    }

    public byte[] getHousePic() {
        return housePic;
    }

    public void setHousePic(byte[] housePic) {
        this.housePic = housePic;
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

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id=" + id +
                ", houseTitle='" + houseTitle + '\'' +
                ", housePrice=" + housePrice +
                ", houseDetail='" + houseDetail + '\'' +
                ", housePic=" + Arrays.toString(housePic) +
                ", createDate=" + createDate +
                ", showorder=" + showorder +
                ", ifshow='" + ifshow + '\'' +
                '}';
    }
}
