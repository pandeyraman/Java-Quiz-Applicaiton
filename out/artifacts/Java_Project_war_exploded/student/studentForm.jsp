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

        <h1>Add New Student</h1>
        <div class="login-bottom">
            <form method="post" action="addStudent">
                <input type="hidden" name="page" value="addStudent">
                <input type="text" placeholder="First Name" class="password" required=" " name="firstname">
                <input type="text" placeholder="Last Name" class="password" required=" " name="lastname">
                <input type="text" placeholder="Roll No" class="password" required=" " name="roll">
                <input type="submit" value="update">
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
