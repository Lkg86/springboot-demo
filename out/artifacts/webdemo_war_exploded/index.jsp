<%--
  Created by IntelliJ IDEA.
  User: Windows10 X64
  Date: 2022/5/17
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--<form action="/user/loin" method="post">--%>
  <%--<div>用户名：<input type="text" name="userName"/></div>--%>
  <%--<div>密码：<input type="password" name="pwd"/></div>--%>
  <%--<div> <input type="submit" value="登录"/></div>--%>
  <%--</form>--%>
 index.jsp

  <hr>
 name= ${user.name}
  <hr>
  id=${user.id}
  <hr>
  host=${user.host}

  <hr>
 jsp name= <%=(String) request.getAttribute("name")%>
  <hr>
  el name=${name}
  </body>
</html>
