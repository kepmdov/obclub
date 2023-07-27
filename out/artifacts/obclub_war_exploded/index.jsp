<%@ page import="java.util.List" %>
<%@ page import="com.cn.enity.HouseInfo" %>
<%@ page import="com.cn.enity.ServiceInfo" %>
<%@ page import="com.cn.enity.ActivityInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>css/bootstarp.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>css/web.css">
</head>
<body>
<%
    List<HouseInfo> houseInfos = (List<HouseInfo>) request.getSession().getAttribute("houseInfos");
    List<ServiceInfo> serviceInfos = (List<ServiceInfo>) request.getSession().getAttribute("serviceInfos");
    List<ActivityInfo> activityInfos = (List<ActivityInfo>) request.getSession().getAttribute("activityInfos");
    Object message = request.getAttribute("message");
    if (message != null && message != "") {
%>
<script type="text/javascript">
    alert("<%=message%>")
</script>
<%}%>

<jsp:include page="WEB-INF/jsp/index/index-header.jsp"/>
<div class="slider row">
    <div class="carousel slider" id="slider" data-ride="carousel" ng-controller="silderCtrl">
        <ol class="carousel-indicators">
            <li class="active" data-target="#silder" data-slide-to="0"></li>
            <li data-target="#slider" data-slide-to="1"></li>
            <li data-target="#slider" data-slide-to="2"></li>
            <li data-target="#slider" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="images/slider2.png" alt="" width="100%" height="400px"/>
            </div>
            <div class="item">
                <img src="images/slider4.png" alt="" width="100%" height="400px"/>
            </div>
            <div class="item">
                <img src="images/slider5.png" alt="" width="100%" height="400px"/>
            </div>
            <div class="item">
                <img src="images/slider3.png" alt="" width="100%" height="400px"/>
            </div>
        </div>
        <a href=".slide" class="left carousel-control" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a href=".slide" class="right carousel-control" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">next</span>
        </a>
    </div>
</div>
<%if (houseInfos != null && activityInfos != null && serviceInfos != null) {%>
<div class="fast-nav">
    <div>
        <ul class="nav-ul">
            <li><a href="#">快速入口</a></li>
            <li><a href="service.jsp">专业服务</a></li>
            <li><a href="activity.jsp">套餐活动</a></li>
            <li><a href="house.jsp">房间介绍</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="more-list">
        <div class="more-list-header">
            <h4>房间介绍</h4> <small>room</small>
            <a href="house.jsp">更多>></a>
        </div>
        <div class="content" style="margin-top: 3px">
            <div class="row">
                <% for (int i = 0; i <= 3; i++) {%>
                <div class="col-lg-3">
                    <div class="img-thumbnail" style="float: left">
                        <a href="house_detail.jsp?id=<%=houseInfos.get(i).getId()%>">
                            <img src="<%=request.getContextPath()%>/images/houseShowPic?id=<%=houseInfos.get(i).getId()%>"
                                 style="height: 195px;width: 260px" class="img-responsive" alt=""/></a>
                        <p><%=houseInfos.get(i).getHouseTitle()%>
                        </p>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </div>
    <div class="more-list">
        <div class="more-list-header">
            <h4>专业服务</h4><small>server</small>
            <a href="service.jsp">更多>></a>
        </div>
        <div class="content" style="margin-top: 3px">
            <div class="row">
                <% for (int i = 0; i <= 3; i++) {%>
                <div class="col-lg-3">
                    <div class="img-thumbnail">
                        <a href="service_detail.jsp?id=<%=serviceInfos.get(i).getId()%>&typeId=<%=serviceInfos.get(i).getServiceType()%>">
                            <img src="<%=request.getContextPath()%>/images/serShowPic?id=<%=serviceInfos.get(i).getId()%>"
                                 style="height: 195px;width: 260px" class="img-responsive" alt=""/>
                        </a>
                        <p><%=serviceInfos.get(i).getSerTitle()%>
                        </p>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </div>
    <div class="more-list">
        <div class="more-list-header">
            <h4>套餐及活动</h4> <small>active</small>
            <a href="activity.jsp">更多>></a>
        </div>
        <div class="content" style="margin-top: 3px">
            <div class="row">
                <% for (int i = 0; i <= 3; i++) { %>
                <div class="col-lg-3">
                    <div class="img-thumbnail" style="float: left">
                        <a href="activity_detail.jsp?id=<%=activityInfos.get(i).getId()%>">
                            <img src="<%=request.getContextPath()%>/images/actShowPic?id=<%=activityInfos.get(i).getId()%>"
                                 style="height: 195px;width: 260px" class="img-responsive" alt=""/>
                        </a>
                        <p><%=activityInfos.get(i).getActTitle()%>
                        </p>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </div>
</div>
<%}%>
<jsp:include page="WEB-INF/jsp/index/index-foot.jsp"/>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
a