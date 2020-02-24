<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 2017/10/10
  Time: 上午10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <%@include file="../../common/head.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/NCUMarket/resource/css/style.css">
</head>
<body style="background: url(/resource/img/login/bg.jpg) no-repeat center 0">
<div class="container" id="chuangkou">
    <div class="row">
        <div class="col-md-4 col-sm-3 col-xs-0"></div>
        <div class="col-md-4 col-sm-6  col-xs-12 dr">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2 class="panel-title"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 登录</h2>

                </div>
                <div class="panel-body">
                    <form action="/NCUMarket/NCUAdmin/confirmLogin" method="post">
                        <div class="row">
                            <div class="col-md-1 col-sm-1 col-xs-1"></div>
                            <div class="col-md-10 col-sm-10 col-xs-10">
                                <p class="errors"></p>
                            </div>
                            <div class=" col-md-1 col-sm-1 col-xs-1"></div>


                        </div>
                        <div class="row ">
                            <div class="col-md-1 col-sm-1 col-xs-1"></div>
                            <div class="form-group col-md-10 col-sm-10 col-xs-10">
                                <input type="num" name="adminNum" class="form-control inputId" id="inputid" a
                                       maxlength="10" placeholder="请输入学号">
                            </div>
                            <div class=" col-md-1 col-sm-1 col-xs-1"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-1 col-sm-1 col-xs-1"></div>
                            <div class="form-group col-md-10 col-sm-10 col-xs-10">
                                <input type="password" class="form-control inputPassword" id="exampleInputPassword1"
                                       name="password" a="0" maxlength="6" placeholder="请输入密码">
                            </div>
                            <div class="col-md-1 col-sm-1 col-xs-1"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-1 col-sm-2 col-xs-2"></div>
                            <div class="col-md-3 col-xs-4 col-sm-4">
                                <!-- <label>
                                   <h5><input type="checkbox"> 记住我</h5>
                                </label> -->
                            </div>
                            <div class="col-md-3 col-xs-1 col-sm-1"></div>
                            <div class="col-md-4 col-xs-4 col-sm-4">
                                <label>
                                    <h5><a href="#" id="forgot_password">忘记密码？</a></h5>
                                </label>
                            </div>
                            <div class="col-md-1 col-sm-1 col-xs-1"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-2"></div>
                            <%--<div class="col-md-8 col-sm-8 col-xs-8">--%>
                            <%--<button type="button" class="btn btn-info dran" id="denglu">登录</button>--%>
                            <%--</div>--%>
                            <div class="col-md-2 col-sm-2 col-xs-2">
                            </div>
                            <input type="submit" value="登陆" class="btn btn-info dran"/>
                        </div>
                    </form>
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-3 col-xs-0">

        </div>
    </div>
</div>
</body>
</html>