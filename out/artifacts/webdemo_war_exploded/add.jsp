<%--
  Created by IntelliJ IDEA.
  User: Windows10 X64
  Date: 2022/5/18
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计在线人数</title>
</head>
<body>
    近30分钟在线人数：${applicationScope.onlineNum}

    <hr>
应用服务器启动后访问次数：${totalVisit}

</body>
</html>
