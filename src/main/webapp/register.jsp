<%--
  Created by IntelliJ IDEA.
  User: Vardg
  Date: 27.12.2019
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (request.getAttribute("abcd") != null) {
        response.getWriter().print(request.getAttribute("abcd"));
    }
%>
<form method="post" action="/register">
    Name:<input type="text" name="name"><br/>
    Surname:<input type="text" name="surname"><br/>
    Age:<input type="text" name="age"><br/>
    Username : <input type="text" name="username"><br/>
    Password : <input type="password" name="pass"><br/>
    Code:<input type="text" name="code"><br/>
    <input type="submit" name="Sign in"><br/>
</form>
</body>
</html>
