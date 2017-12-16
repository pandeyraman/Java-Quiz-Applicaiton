<%--
  Created by IntelliJ IDEA.
  User: xmen_alive
  Date: 7/16/17
  Time: 8:54 PM
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
            <h1>Add New User</h1>
            <div class="login-bottom">
                <form method="post" action="addUser">
                    <input type="hidden" name="page" value="addUser">
                    <input type="text" placeholder="Username" class="password" required=" " name="username">
                    <input type="text" placeholder="Password" class="password" required=" " name="password">
                    <input type="text" placeholder="Role" class="password" required=" " name="role">
                    <input type="submit" value="update">
                </form>
                <%--<a href="#"><p>Forgot your password? Click Here</p></a>--%>
            </div>
        </div>
</div>
</body>
</html>
