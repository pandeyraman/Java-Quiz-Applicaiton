<%--
  Created by IntelliJ IDEA.
  User: xmen_alive
  Date: 7/16/17
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/favicon.ico">

    <title>Login Pannel</title>

        <link href="css/form-style.css" rel="stylesheet">
</head>

<body>
<div class="main">
    <div class="login">
        <div class="login-top">
            <img src="../images/p.png">
        </div>
        <h1>Admin Login</h1>
        <div class="login-bottom">
            <form method="post" action="login">
                <input type="hidden" name="page" value="login">
                <input type="text" placeholder="Username" required=" " name="username">
                <input type="password" class="password" placeholder="Password" required=" " name="password">
                <input type="submit" value="login">
            </form>
            <a href="#"><p>Forgot your password? Click Here</p></a>
        </div>
    </div>
</div>
<div class="footer">
    <p>&copy 2017 <b>Raman Pandey</b>. All rights reserved | Design by <a href="http://www.ramanpandey.com.np/">Raman Pandey</a></p>
</div>

</body>
</body>
</html>

