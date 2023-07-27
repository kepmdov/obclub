<%@ page import="java.util.List" %>
<%@ page import="com.cn.enity.ActivityInfo" %>
<%@ page import="com.cn.enity.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="
<%=request.getContextPath()%>/css/bootstrap.min.css"/>
</head>
<body>
<%
    List<ActivityInfo> activityInfos =
            (List<ActivityInfo>) request.getAttribute("activityInfos");
    List<ActivityInfo> list = (List<ActivityInfo>) request.getAttribute("list");
    Page page1 = (Page) request.getAttribute("page");
    if(page1==null){
        System.out.println("null");
    }
    Object message = request.getAttribute("message");
    if (message != null && message != "") {
%>
<script type="text/javascript">
    alert("<%=message%>")
</script>
<%}%>
<jsp:include page="../index/index-header.jsp"/>
<div ng-controller="activeCtrl" class="container" ng-init="getData()">
    <img src="<%=request.getContextPath()%>/images/slider2.png" alt=""
         width="100%" style="margin-bottom: 10px"/>
    <div class="row">
        <div class="col-lg-4">
            <%for (int i = 0; i < list.size(); i++) {%>
            <ul class="list-group">
                <li class="list-group-item" ng-repeat="item in data"><a
                        href="activity_detail.jsp?id=<%=list.get(i).getId()%>">
                    <%=list.get(i).getActTitle()%>
                </a></li>
            </ul>
            <%}%>
        </div>
        <div class="col-lg-8">
            <div class="media" ng-repeat="item in data">
                <% for (int i = 0; i < page1.getPageSize(); i++) {%>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="media-left">
                            <a href="activity_detail.jsp?id=<%=activityInfos.get(i).getId()%>">
                                <img class="media-object" width="64px"height="64px" src="<%=request.getContextPath()%>/images/actShowPic?id=<%=activityInfos.get(i).getId()%>" alt="..."/>
                            </a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <%=activityInfos.get(i).getActTitle()%>
                            </h4>
                            <p>��۸�:
                                <%=activityInfos.get(i).getActPrice()%>
                            </p>
                        </div>
                        <div class="media-right">
                            <a href="activity_detail.jsp?id=<%=activityInfos.get(i).getId()%>" class="btn btn-zise">��ϸ</a>
                        </div>
                    </div>
                    <div class="panel-collapse">
                        <div class="panel-body">
                            <p>��ʼʱ��:
                                <%=activityInfos.get(i).getStartDate()%>
                            </p>
                            <p>����ʱ��:<%=activityInfos.get(i).getEndDate()%>
                            </p>
                            <p>�����:
                                <%=activityInfos.get(i).getActDetail()%>
                            </p>
                        </div>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="btn-group col-xs-offset-5">
            <ul class="pagination">
                <li><a href="activity.jsp?pageCurrent=<%=(page1.getPageCurrent()-1 <=
0)?(1):(page1.getPageCurrent()-1)%>">&laquo;</a></li>
                <%for (int i = 1; i <= page1.getPageTotal(); i++) {%>
                <li><a href="activity.jsp?pageCurrent=<%=i%>"><%=i%>
                </a>
                </li>
                <%}%>
                <li><a href="activity.jsp?pageCurrent=<%=(page1.getPageCurrent()
>= page1.getPageTotal())?(page1.getPageCurrent()):
(page1.getPageCurrent()+1)%>">&raquo;</a></li>
            </ul>
        </div>
    </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>
<script rel="script" src="../../../js/bootstrap.min.js"/>
<script src="../../../js/angular-cookies.js"/>
</body>
</html>