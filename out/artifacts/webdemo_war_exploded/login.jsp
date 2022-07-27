<%--
  Created by IntelliJ IDEA.
  User: Windows10 X64
  Date: 2022/5/18
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>


<form action="<%=request.getContextPath()%>/loginServlet" method="post">


    名称：<input type="text" name="name"/>

    <br/>
    密码：<input type="password" name="pwd"/>

    <input type="submit" value="登录">

    消息提示 ${msg}
</form>

</body>
</html>
