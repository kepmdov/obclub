package com.cn.enity;

import java.util.Date;

public class JobInfo {
    private Long id;
    private String jobTitle;
    private String jobDetail;
    private Date createdate;
    private Integer showorder;
    private String ifshow;

    public JobInfo() {
    }

    public JobInfo(String jobTitle, Date createdate, Integer showorder, String ifshow) {
        this.jobTitle = jobTitle;
        this.createdate = createdate;
        this.showorder = showorder;
        this.ifshow = ifshow;
    }

    public JobInfo(String jobTitle, String jobDetail, Date createdate, Integer showorder, String ifshow) {
        this.jobTitle = jobTitle;
        this.jobDetail = jobDetail;
        this.createdate = createdate;
        this.showorder = showorder;
        this.ifshow = ifshow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
        return "JobInfo{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDetail='" + jobDetail + '\'' +
                ", createdate=" + createdate +
                ", showorder=" + showorder +
                ", ifshow='" + ifshow + '\'' +
                '}';
    }
}
