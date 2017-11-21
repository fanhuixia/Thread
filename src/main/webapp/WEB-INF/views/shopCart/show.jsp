<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/20 0020
  Time: 上午 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>我的购物车</h1>

    <c:forEach var="goods" items="${shopCart.goods}">
        <div> ${goods.name} &nbsp;&nbsp; &nbsp; &nbsp;
            <span id="price_${goods.id}">  ${goods.price}</span> &nbsp;&nbsp; &nbsp; &nbsp;
           ${goods.count}  &nbsp;&nbsp; &nbsp; &nbsp;
                <span id="cal_${goods.id}"> ${goods.count * goods.price}</span>
              <input id="goods_${goods.id}" type="text" name="count" value="${goods.count}"> <input data-goodsId="${goods.id}" class="btn_updateCount" type="button" value="修改数量">
        </div>

    </c:forEach>

    <h1> 总价: <span id="totalPrice"> ${shopCart.totalPrice}</span>    <input type="button" value="去结算"> </h1>
    <a href="${pageContext.request.contextPath}/goods/index">继续购物</a>

    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>

    <script>

        var ctx="${pageContext.request.contextPath}";
        jQuery(function($){
          $(document).on("click",".btn_updateCount",function(){

                //获取商品ID
               var goodsId=$(this).attr("data-goodsId");
              //获取商品数量
              var count=$("#goods_"+goodsId).val();

              $.post(ctx+"/shopCart/updateCount",{goodsId:goodsId,count:count},function(data){
                    if(data && data.success){
                        //修改小计数量
                        //价格
                       var price= $("#price_"+goodsId).text();
                        $("#cal_"+goodsId).text(parseFloat(price)*count);
                        //修改总价格
                        $("#totalPrice").text(data.total);
                    }
              });

          });
        })


    </script>
</body>
</html>
