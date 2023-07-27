<%@ page contentType="text/html;charset=GBK" language="java" %>
<jsp:include page="WEB-INF/jsp/index/index-header.jsp"/>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/web.css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <label class="col-sm-12"><h2>��Աע��</h2></label>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-7">
            <div class="row">
                <div class="col-sm-12">
                    <form action="register" method="post">
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberUserName">�û�����</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txt_memberUserName" name="memUsername"
                                       placeholder="�û���" required/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberPassword">���룺</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="txt_memberPassword" name="memPassword"
                                       placeholder="����" required/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberName">������</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txt_memberName" name="memName"
                                       placeholder="����" required/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberName">���䣺</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txt_memberAge" name="memAge"
                                       placeholder="����" required/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="select_memberSex">�Ա�</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="select_memberSex" name="memSex" required="">
                                    <option value="��">��</option>
                                    <option value="Ů">Ů</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="height:40px">
                            <label class="col-sm-2 control-label" for="txt_memberTel">��ϵ�绰��</label>
                            <div class="col-sm-10">
                                <input type="tel" class="form-control" id="txt_memberTel" name="memTel"
                                       placeholder="��ϵ�绰"/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberPhone">�ֻ���</label>
                            <div class="col-sm-10">
                                <input type="tel" class="form-control" id="txt_memberPhone" name="memPhone"
                                       placeholder="�ֻ�" required=""/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberEmail">�������䣺</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="txt_memberEmail" name="memEmail"
                                       placeholder="email" required=""/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberAddress">��ͥסַ��</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txt_memberAddress" name="memAddress"
                                       placeholder="��ͥסַ" required=""/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="file_memberPic">ͷ���ϴ���</label>
                            <div class="col-sm-10">
                                <input type="file" class="form-control"
                                       id="file_memberPic" name="uploadPic" placeholder="ͷ���ϴ�"/>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="col-sm-12 btn btn-primary">�ύ</button>
                            </div>
                        </div>
                        <jsp:setProperty name="member" property="*"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-xs-5">
            <img class="pull-right qr-code-size" src="images/erweima.png" alt=""
            />
        </div>
    </div>
</div>
<jsp:include page="WEB-INF/jsp/index/index-foot.jsp"/>
</body>
</html>