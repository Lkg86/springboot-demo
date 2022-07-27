<%--
  Created by IntelliJ IDEA.
  User: Windows10 X64
  Date: 2022/5/18
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计人下线</title>
</head>
<body>
销毁Seesion
<hr>

<% request.getSession().invalidate();%>

</body>
</html>
