<%--
  Created by IntelliJ IDEA.
  User: xmen_alive
  Date: 7/16/17
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/form-style.css" rel="stylesheet">

</head>
<body>
<div class="main">
    <div class="login">
        <div class="login-top">
            <img src="../image/p.png">
        </div>
        <h1>Update Student</h1>
        <div class="login-bottom">
            <form method="post" action="editStudent">
                <input type="hidden" name="page" value="update">
                <input type="text" name="id"  value="${student.id}">
                <h4 style="text-align: center;font-size:20px">First Name</h4>
                <input type="text" required=" " class="password"name="firstname" value="${student.firstname}" >
                <h4 style="text-align: center;font-size:20px">Last Name</h4>
                <input type="text"  required=" "class="password" name="lastname" value="${student.lastname}">
                <h4 style="text-align: center;font-size: 20px;">Roll</h4>
                <input type="text" required=" "class="password" name="roll"value="${student.roll}">
                <input type="submit" value="Update">
            </form>
            <%--<a href="#"><p>Forgot your password? Click Here</p></a>--%>
        </div>
    </div>
</div>
<div class="footer">
    <p>&copy 2017 <b>Raman Pandey</b>. All rights reserved | Design by <a href="http://www.ramanpandey.com.np/">Raman Pandey</a></p>
</div>
</body>
</html>
