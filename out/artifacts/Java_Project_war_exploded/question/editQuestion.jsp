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
        <div class="login-top">
            <img src="../image/p.png">
        </div>
        <h1>Update Question</h1>
        <div class="login-bottom">
            <form method="post" action="editQuestion">
                <input type="hidden" name="page" value="update">
                <input type="text" name="id"  value="${question.id}">
                <h4 style="text-align: center;font-size:20px">Question</h4>
                <input type="text"  placeholder="Question" required=" " class="password"name="question" value="${question.question}" >
                <h4 style="text-align: center;font-size:20px">Category</h4>
                <input type="text" placeholder="Category" class="password" required=" " name="category" value="${question.category}">
                <h4 style="text-align: center;font-size:20px">Option 1</h4>
                <input type="text" placeholder="Option 1" class="password" required=" " name="option_1" value="${question.option_1}">
                <h4 style="text-align: center;font-size:20px">Option 2</h4>
                <input type="text" placeholder="Option 2" class="password" required=" " name="option_2" value="${question.option_2}">
                <h4 style="text-align: center;font-size:20px">Option 3</h4>
                <input type="text" placeholder="Option 3" class="password" required=" " name="option_3" value= "${question.option_3}">
                <h4 style="text-align: center;font-size:20px">Option 4</h4>
                <input type="text" placeholder="Option 4" class="password" required=" " name="option_4" value= "${question.option_4}">
                <h4 style="text-align: center;font-size:20px">Correct Answer</h4>
                <input type="text" placeholder="Correct Answer" class="password" required=" " name="correct_ans" value= "${question.correct_ans}">
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
