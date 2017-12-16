<%--
  Created by IntelliJ IDEA.
  User: xmen_alive
  Date: 7/17/17
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>-
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Java Project</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->

</head>
<body>
<jsp:include page="../menu/navbar.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row" style="background: #bce8f1;">
        <div class="col-md-2"></div>
        <div class="col-md-8" style="padding: 30px;">

            <form method="post" action="getQuestion">
                <input type="hidden" name="id" value="${question.id}">
                <input type="hidden" name="page" value="quiz">
                <input type="hidden" name="page" value="next">
                <input type="hidden" name="page" value="result">
                <input type="hidden" name="correct" value="${question.correct_ans}">
                <input type="hidden" name="question" value="${question.question}">
                <ul style="list-style-type: none;">
                    <h1>Tick the correct answer</h1>
                    <h3>${question.question}</h3>
                    <li><input type="radio" value="${question.option_1}" name="option" onClick="document.getElementById('subutton').disabled = false">${question.option_1}</li>
                    <li><input type="radio" value="${question.option_2}" name="option" onClick="document.getElementById('subutton').disabled = false">${question.option_2}</li>
                    <li><input type="radio" value="${question.option_3}" name="option"onClick="document.getElementById('subutton').disabled = false">${question.option_3}</li>
                    <li><input type="radio" value="${question.option_4}" name="option"onClick="document.getElementById('subutton').disabled = false">${question.option_4}</li>
                    <br>
                    <li><input id="subutton" type="submit" name="submit" value="Next" disabled/></li>
                </ul>
            </form>
        </div>
        <div class="col-md-2"></div>

    </div>
</div>
</body>
</html>
