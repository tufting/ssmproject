<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/2/1
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/2/1
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//    System.out.println(basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改书籍</title>

    <%--BootStrap--%>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap-theme.min.css">
    <%--使用bootstrap所依赖的jquery--%>
    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <%--bootstrap的所有javaScript插件--%>
    <script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--前端传递隐藏域，传递id到后端，不然进行书籍修改时，BookID=0--%>
        <input type="hidden" name="bookID" value="${query_book.bookID}"/>
        书籍名称：<input type="text" name="bookName" value="${query_book.bookName}" required><br><br><br>
        书籍数量：<input type="text" name="bookCounts" value="${query_book.bookCounts}" required><br><br><br>
        书籍详情：<input type="text" name="detail" value="${query_book.detail}" required><br><br><br>
        <input type="submit" value="确认修改">
    </form>

</div>

</body>
</html>

