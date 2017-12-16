<%--
  Created by IntelliJ IDEA.
  User: xmen_alive
  Date: 7/16/17
  Time: 8:52 PM
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

        <h1>Add New Question</h1>
        <div class="login-bottom">
            <form method="post" action="addQuestion">
                <input type="hidden" name="page" value="addQuestion">
                <input type="text" placeholder="Question" class="password" required=" " name="question">
                <input type="text" placeholder="Category" class="password" required=" " name="category">
                <input type="text" placeholder="Option 1" class="password" required=" " name="option_1">
                <input type="text" placeholder="Option 2" class="password" required=" " name="option_2">
                <input type="text" placeholder="Option 3" class="password" required=" " name="option_3">
                <input type="text" placeholder="Option 4" class="password" required=" " name="option_4">
                <input type="text" placeholder="Correct Answer" class="password" required=" " name="correct_ans">
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
