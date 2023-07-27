<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<jsp:include page="../index/index-header.jsp"/>
<jsp:useBean id="serviceInfo" class="com.cn.enity.ServiceInfo"
             scope="session"/>
<jsp:useBean id="serviceType" class="com.cn.enity.ServiceType"
             scope="session"/>
<div ng-controller="serviceInfoCtrl">
  <div class="row">
    <div class="col-xs-12" style="border-bottom: 1px solid lightgray; margin-bottom: 15px">
      <h1 class="text-center"><jsp:getProperty name="serviceInfo"
                                               property="serTitle"/></h1>
    </div>
  </div>
  <div class="row" style="margin-bottom: 15px">
    <div class="col-xs-12">
      <img src="<%=request.getContextPath()%>/images/serShowPic?id=
<jsp:getProperty name="serviceInfo" property="id"/>" class="center-block"
           style="width: 800px" />
    </div>
  </div>
  <div class="container">
    <dl class="dl-horizontal">
      <dt>
        �������ƣ�
      </dt>
      <dd>
        <jsp:getProperty name="serviceInfo" property="serTitle"/>
      </dd>
    </dl>
    <dl class="dl-horizontal">
      <dt>
        �������ͣ�
      </dt>
      <dd>
        <jsp:getProperty name="serviceType" property="typeTitle"/>
      </dd>
    </dl>
    <dl class="dl-horizontal">
      <dt>
        ����������
      </dt>
      <dd><jsp:getProperty name="serviceInfo" property="serDetail"/>
      </dd>
    </dl>
  </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>
</body>
</html>