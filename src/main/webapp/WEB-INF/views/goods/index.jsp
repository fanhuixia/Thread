<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/20 0020
  Time: 上午 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:forEach var="goods" items="${goodsList}">
    <div>
        ${goods.name} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        ${goods.price}
        <a href="${pageContext.request.contextPath}/shopCart/add?goodsId=${goods.id}">加入购物车</a>


    </div>
    </c:forEach>
</body>
</html>
