<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 2017/10/11
  Time: 上午11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../../common/tag.jsp" %>
    <meta charset="utf-8"/>
    <title>NCU二货集市审核</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="/resource/css/goods.css">
</head>

<body>
<div class="container">
    <!--导航  -->
    <div class="nav">
        <div class="row">
            <div class="col-md-1 col-sm-1 col-xs-1"></div>
            <div class="col-md-2 col-sm-6 col-xs-6 nav_title">商品发布审核</div>
            <div class="col-md-7 col-sm-1 col-xs-1"></div>
            <div class="col-md-2 col-sm-4 col-xs-4 nav_adminInfo">
                <span class="welcome">欢迎你</span> <span class="my_name">张淑平</span>
            </div>
        </div>
    </div>

    <c:forEach items="${products}" var="P">
        <div class="product">

            <!-- 商品简介 -->
            <div class="productInfo">
                <div class="productName">${fn:escapeXml(P.productTittle)}</div>
                <div class="productPrice">${fn:escapeXml(P.productPrice)}</div>
            </div>


            <!-- 交易情况 -->
            <div class="transcation">
                <span class="transcationInfo">线下交易</span>
            </div>
            <!-- 商品展示图 -->
            <div class="product_img">
                <div class="productShowDesc">
                    <span>${fn:escapeXml(P.productInfo)}</span>
                </div>
                <div class="productShowImg">
                    <img src="${fn:escapeXml(P.productImgurl)}_1.jpg?imageView2/1/w/320/format/jpg/q/75|imageslim"
                         alt="">
                </div>
            </div>


        </div>

        <div class="row">
            <div class="button">
                <div class="col-xs-5">
                    <button type="button" class="btn btn-warning" id="noPass"
                            onclick="check(false,${P.id},'${P.sellerOpenid}')">不通过
                    </button>
                </div>
                <div class="col-xs-2"></div>
                <div class="col-xs-5">
                    <button type="button" class="btn btn-success" id="pass"
                            onclick="check(true,${P.id},'${P.sellerOpenid}')">通过
                    </button>
                </div>

            </div>

        </div>
    </c:forEach>


    <div class="footer"></div>
</div>
<script>
    function check(a, b, c) {
        console.log("-------------------")
        if (!a) {

            if (confirm("你确定要不通过此商品的审核？")) {
                $.ajax({
                    type: 'post',
                    url: 'check/' + b,
                    data: {isPass: a, sellerOpenid: c},
                    dataType: 'json',
                    success: function (result) {
                        try {
                            $("#pass").attr("disabled", true);
                            $("#nopass").attr("disabled", true);
                        } catch (e) {
                            alert(e);
                            return;

                        }

                    },
                    error: function () {


                    }
                })


            } else {

            }

        } else {
            $.ajax({
                type: 'post',
                url: 'check/' + b,
                data: {isPass: a, sellerOpenid: c},
                dataType: 'json',
                success: function (result) {
                    try {
                        $("#pass").attr("disabled", true);
                        $("#nopass").attr("disabled", true);
                    } catch (e) {
                        alert(e);
                        return;

                    }

                },
                error: function () {


                }
            })

        }


    }


</script>
</body>
</html>
