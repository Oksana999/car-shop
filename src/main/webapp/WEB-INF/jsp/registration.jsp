<%--
  Created by IntelliJ IDEA.
  User: wrros
  Date: 4/24/2019
  Time: 2:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/static/css/myForm.css"/>
    <link rel="stylesheet" href="/static/css/app.css"/>

        <style type="text/css">
            body{
                background-color: #6D84F8;
            }
        </style>
</head>
<body>

<%--    <input type="button" value="Home " id="home"  />--%>
    <a href="${pageContext.request.contextPath}/home">Home</a>


<div class="myForm">
    <h1>Registration form</h1>
    <form  method = "post" action ="${pageContext.request.contextPath}/checkRegistration">

        First Name: <input type="text" name="fName"/>
        <br>
        Last Name: <input type="text" name="lName"/>
        <br>
        Email: <input type="text" name="email"/>
        <br>
        Password: <input type="text" name="password"/>

        <input type="submit"/>
    </form>
</div>


</body>
</html>
