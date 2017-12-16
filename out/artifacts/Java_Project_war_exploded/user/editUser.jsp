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
        <h1>Update User</h1>
        <div class="login-bottom">
            <form method="post" action="editUser">
                <input type="hidden" name="page" value="update">
                <input type="hidden" name="id"  value="${user.id}">
                <h4 style="text-align: center;font-size:20px">Username</h4>
                <input type="text" required=" " class="password"name="username" value="${user.username}" >
                <h4 style="text-align: center;font-size:20px">Password</h4>
                <input type="text"  required=" "class="password" name="password" value="${user.password}">
                <h4 style="text-align: center;font-size: 20px;">Role</h4>
                <input type="text" required=" "class="password" name="role"value="${user.role}">
                <input type="submit" value="Update">
            </form>
        </div>
    </div>
</div>
<div class="footer">
    <p>&copy 2017 <b>Raman Pandey</b>. All rights reserved | Design by <a href="http://www.ramanpandey.com.np/">Raman Pandey</a></p>
</div>
</body>
</html>
