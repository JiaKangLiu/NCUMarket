<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 2017/7/31
  Time: 下午7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${rServices}" var="RS">
    <%--service start--%>
    <!--最新服务 -->
    <div style="background: white;margin-top: 5px  ">
        <!-- 用户信息 -->
        <div class="ServiceBox">
            <div>
                <!-- 头像 -->
                <div class="headBox">
                    <img data-original="http://otlk76aak.bkt.clouddn.com/${RS.userHead}" class="headImg">
                </div>
                <div class="uBox">
                    <!-- 姓名 -->
                    <div>
                        <p class="uname">${fn:escapeXml(RS.userName)}</p>
                    </div>
                    <!-- 简介 -->

                    <div>
                        <p class="uinfo">${fn:escapeXml(RS.userInfo)}</p>
                    </div>
                    <!--=============================粉丝数量...=============================== -->
                    <div></div>
                </div>
            </div>
            <!-- 服务图片 -->
            <div>
                <img data-original="http://otlk76aak.bkt.clouddn.com/BRC/IMG/Service/${RS.id}.jpg?imageView2/1/w/720/h/300/format/webp/q/75|imageslim"
                     class="ServiceImg">
            </div>
            <div>
                <p class="sinfo">I CAN:${fn:escapeXml(RS.serviceTittle)}</p>
            </div>
            <div>
                <p class="sinfo">${fn:substring(fn:escapeXml(RS.serviceInfo),0,50)}......</p>
            </div>
                <%--服务价格等信息--%>
            <div class="sFooter">
                <div class="sSaleCounts"><strong>库存:${RS.serviceStock}</strong></div>
                <div class="sPrice"><strong>单价:${RS.servicePrice}</strong></div>
            </div>
        </div>
        <!-- 服务介绍 -->
    </div>
    <%--service end--%>
</c:forEach>

<script type="text/javascript">
    // $("img").lazyload();
    $("img").lazyload({
        effect: "fadeIn",
        failure_limit: 10,
        threshold: 500
    })
</script>