<%--
  Created by IntelliJ IDEA.
  User: jamesbean
  Date: 2020/5/21
  Time: 12:37 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>111</title>
  </head>
  <body>
<%--
    <a href="hello">hello</a>
--%>



    <%--Redirect--%>
    <a href="/springmvc/testRedirect">test Redirect</a>
    <br>

    <%--View--%>
    <a href="/springmvc/testView">test View</a>
    <br>

    <%--ViewAndViewResolver--%>
    <a href="/springmvc/testViewAndViewResolver">test ViewAndViewResolver</a>
    <br>

    <%--modelAttributes--%>
    <a href="/springmvc/testModelAttributes?id=1">test ModelAttributes</a>
    <br>

    <%--sessionAttributes--%>
    <a href="/springmvc/testSessionAttributes">test SessionAttributes</a>
    <br>

    <%-- 目标参数 map modelAndView --%>
    <a href="/springmvc/testMap">test map</a>
    <br>
    <a href="/springmvc/testModelAndView">test ModelAndView</a>
    <br>

    <%--Servlet AIP--%>
    <a href="/springmvc/testServletAPIWriter">Servlet AIP Writer</a>
    <br>
    <a href="/springmvc/testServletAPI">Servlet AIP</a>
    <br>

    <%--POJO--%>
    <form action="/springmvc/testPojo" method="post">
        username:<input type="text" name="username" value="">
        <br>
        password<input type="password" name="password" value="">
        <br>
        email:<input type="text" name="email" value="">
        <br>
        age:<input type="text" name="age" value="">
        <br>
        city:<input type="text" name="address.city" value="">
        <br>
        province:<input type="text" name="address.province" value="">
        <br>
        <input type="submit" value="提交">
    </form>


    <a href="/springmvc/testCookieValue">Test CookieValue</a>
    <br>

    <a href="/springmvc/testRequestHeader">Test RequestHeader</a>
    <br>

    <%--RequestParam--%>
    <a href="/springmvc/testRequestParam?username=wz">Test RequestParam defaultValue required</a>
    <a href="/springmvc/testRequestParam?username=wz&age=24">Test RequestParam</a>

    <br>


    <%-- post get delete put --%>
    <form action="/springmvc/testRest/4" method="post">
        <input type="hidden" name="_method" value="PUT">

        <input type="submit" value="Test Rest POST">
    </form>
    <br><br>

    <form action="/springmvc/testRest/3" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="Test Rest POST">
    </form>
    <br><br>

    <form action="/springmvc/testRest/2" method="post">
        <input type="submit" value="Test Rest POST">
    </form>
    <br><br>

    <a href="/springmvc/testRest/1">Test Rest GET</a>
    <br><br>

    <%-- PathVariable --%>
    <a href="/springmvc/testPathVariable/10">testPathVariable</a>



    <%--Ant表达式--%>
    <a href="/springmvc/testAntPath/tongpei/abc">testAntPath</a>


    <%-- 请求参数与请求头 --%>
    <a href="/springmvc/testParamsAndHeaders?username=guigu&age=11">testParamsAndHeaders</a>

    <br>

    <%--get 请求 与 post 请求--%>
    <form action="/springmvc/getOrPost">
     <input type="submit" value="get请求">
    </form>
    <form action="/springmvc/getOrPost" method="post">
      <input type="submit" value="post请求">
    </form>


    <a href="/springmvc/requestMapping">hello</a>

  </body>
</html>
