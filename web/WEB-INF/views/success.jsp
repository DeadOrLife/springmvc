<%--
  Created by IntelliJ IDEA.
  User: jamesbean
  Date: 2020/5/21
  Time: 12:37 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  hello world

  ${requestScope.time}
  <br><br>


  name:${requestScope.name}
  <br><br>


  request:${requestScope.user}
  request:${requestScope.school}
  <br><br>

  session:${sessionScope.user}
  session:${sessionScope.school}

  <br><br>
  abc:${requestScope.abc}
  <br><br>


  mnxyz user: ${requestScope.mnxyz }
  <br><br>

  <%--<fmt:message key="i18n.username"></fmt:message>
  <br><br>

  <fmt:message key="i18n.password"></fmt:message>
  <br><br>
--%>
  </body>
</html>
