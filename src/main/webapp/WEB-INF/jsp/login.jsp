<%--
  Created by IntelliJ IDEA.
  User: wrros
  Date: 4/24/2019
  Time: 2:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/static/css/myForm.css"/>
    <link rel="stylesheet" href="css/app.css"/>

    <style type="text/css">
        body{
            background-color: #6D84F8;
        }
    </style>

</head>
<body>

<div class="myButton">

    <a href="${pageContext.request.contextPath}/home">Home</a>
</div>

<div class="myForm">
    <h1>Please login to proceed</h1>
    <form  method = "post" action ="${pageContext.request.contextPath}/checkLogin">
        Email: <input type="text" name="email"/>
        <br>
        Password: <input type="text" name="password"/>

        <input type="submit"/>
    </form>
</div>

</body>
</html>
