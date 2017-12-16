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
    <title>Student List</title>
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
    <link href="../css/style_new.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<jsp:include page="../menu/navbar.jsp"></jsp:include>
<section id="main" class="wrapper">
    <div class="container">
        <section>

            <nav id="nav" class="nav-tabs-justified nav navbar-right">

            </nav>
            <h3>Table</h3>

            <div class="table-wrapper">

                <table>

                    <thead >
                    <tr>
                        <th><bold>Qid</bold></th>
                        <th>UID</th>
                        <th>Question</th>
                        <th>Clicked Answer</th>
                        <th>Correct Answer</th>
                        <th>Marks</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${quizResult}" var="quizResult">
                               <tr>
                                   <td>${quizResult.qId}</td>
                                   <td>${quizResult.uid}</td>
                                   <td>${quizResult.question}</td>
                                    <td>${quizResult.clicked}</td>
                                    <td>${quizResult.correct}</td>
                                    <td>${quizResult.marks}</td>


                    </c:forEach>

                    </tbody>
                </table>
                <div class="wrapper">
                    <center>

                           <button class="button btn btn-success" style="font-size: 25px;">Total Marks=${total_marks}</button>
                    </center>
                </div>
            </div>
        </section>
    </div>
</section>
</body>
</html>
