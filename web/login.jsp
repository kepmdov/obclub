<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head lang="en">
    <meta charset="GBK">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/web.css"/>
</head>
<body>
<jsp:include page="WEB-INF/jsp/index/index-header.jsp"/>
<%
    Object message = request.getAttribute("message");
    if (message != null && message!=""){
%>
<script type="text/javascript">
    alert("<%=message%>")
</script>
<%}%>
<div class="login" >
    <div class="col-lg-offset-4 col-md-offset-4 col-sm-offset-4 col-lg-4 col-md-4 col-sm-4" style="height: 300px; border-radius: 5px; background-color:#EFEFEF; padding-top: 50px; padding-bottom: 15px">
        <form action="login" method="post">
            <div class="form-list">
                <%--@declare id="txt_userid"--%><label class="control-label" for="txt_userId">用户名</label>
                <div class="input-group">
                       <span class="input-group-addon">
                           <span class="glyphicon glyphicon-user"></span>
                       </span>
                    <input class="form-control" name="username" type="text"
                           size="16" value="" style="background-color: white" placeholder="User ID"
                           required/>
                </div>
            </div>
            <div class="form-group">
                <%--@declare id="txt_password"--%><label class="control-label" for="txt_password">密码</label>
                <div class="input-group">
                       <span class="input-group-addon">
                           <span class="glyphicon glyphicon-lock"></span>
                       </span>
                    <input class="form-control" name="password"
                           type="password" size="16" value="" style="background-color: white"
                           placeholder="Password" required/>
                </div>
            </div>
            <div class="form-group" style="margin-top: 30px">
                <input class="form-control btn btn-success" name="submit"
                       type="submit" value="登录"/>
                <a href="register.jsp" style="float: right">现在注册>></a>
            </div>
        </form>
    </div>
</div>
<jsp:include page="WEB-INF/jsp/index/index-foot.jsp"/>
</body>
</html>