<%--
  Created by IntelliJ IDEA.
  User: wrros
  Date: 4/22/2019
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
    $(document).ready(function () {
        /*function for show and hide form for creating account*/


        $('#replenishmentButton').click(function () {
            $('.replenishment').toggle();
        });


        /*method for sending form with class .sendForm to backend*/
        $(".sendForm")
            .submit(function (e) {
                e.preventDefault(); // avoid to execute the actual submit of the form.
                var form = $(this);
                var url = form.attr('action');
                $.ajax({
                    type: "POST",
                    url: url,
                    data: form.serialize(), // serializes the form's elements.
                    success: function (data) {
                        alert(data);
                    }
                });
            });

    });

</script>

<%--<mvc:annotation-driven />
<mvc:resources mapping="/images/**" location="resources/images/cars/" />--%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style type="text/css">
        body { margin: 0; }

        #header {
            position: fixed; /* Фиксированное положение */
            background-color: dimgray;

            left: 0; top: 0; /* Левый верхний угол */
            padding: 30px; /* Поля вокруг текста */
            background: blueviolet; /* Цвет фона */
            color: white; /* Цвет текста */
            width: 100%; /* Ширина слоя */
            text-align: left;

        }


        #header .right {
            float: right;
            /*display: flex;*/
            /*justify-content: right;*/
            /*flex: 1 1 90%;*/
        }

       body {
            position: fixed; /* Фиксированное положение */
            left: 0; top: 50px; /* Левый верхний угол */
            padding: 30px; /* Поля вокруг текста */
            background-image: url("../../static/images/bg1.jpg")  ;
            width: 70%; /* Ширина слоя */
            height: 80%;
            background-size: cover;
            /*background: lightsteelblue; !* Цвет фона *!*/
            color: white; /* Цвет текста */

            text-align: center;
        }

        img {
            width: 900px;
            height: 650px;
        }
    </style>

    <title>Hello</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.0/normalize.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.0/normalize.min.css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu+Mono" rel="stylesheet">
    <!--link rel="stylesheet" href="static/css/myForm.css"/-->
    <!--link rel="stylesheet" href="css/app.css"/-->
</head>
<body>

<%--    <p><img src="/static/images/bg.jpg" alt="Письма мастера дзен">:1</p>--%>
<%--    <p><img src="static/images/bg.jpg" alt="Письма мастера дзен">:2</p>--%>



       <div id="header">
           <a href="${pageContext.request.contextPath}/registration">Register</a>


                    <c:choose>
<%--                        <c:when test="${user != null}">--%>
                        <c:when test="${sessionScope.currentUser == null}">
                            <a href="${pageContext.request.contextPath}/login">Login</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/logout">Logout</a>
                        </c:otherwise>
                    </c:choose>

           <div class="right">

           <c:choose>
               <c:when test="${sessionScope.currentUser != null}">
                   <input type="button" value="Add Money to Your Account " id="replenishmentButton"  />
               </c:when>
           </c:choose>

           <div class="replenishment" style="display:none">
               <br>
               <form class="sendForm"
                     method="post" action="${pageContext.request.contextPath}/replenishment">

                   <br>
                   <lable>Amount:</lable>
                   <input type="text" name="amount">
                   <input type="hidden" name="userId" value="${sessionScope.currentUser.userId}">
                   <input type="submit" name="submit">
               </form>

           </div>

           </div>

                <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
            </div>


       <div class="content">
            <h1>Welcome to Our Car Shop</h1>

        </div>
<%--<c:choose>--%>
<%--       <c:when test="${sessionScope.currentUser != null}">--%>
<%--           <input type="button" value="Add Money to Your Account " id="replenishmentButton"  />--%>
<%--       </c:when>--%>
<%--</c:choose>--%>

<%--       <div class="replenishment" style="display:none">--%>
<%--           <br>--%>
<%--           <form class="sendForm"--%>
<%--                 method="post" action="${pageContext.request.contextPath}/replenishment">--%>

<%--               <br>--%>
<%--               <lable>Amount:</lable>--%>
<%--               <input type="text" name="amount">--%>
<%--               <input type="hidden" name="userId" value="${sessionScope.currentUser.userId}">--%>
<%--               <input type="submit" name="submit">--%>
<%--           </form>--%>

<%--       </div>--%>

</body>
</html>
