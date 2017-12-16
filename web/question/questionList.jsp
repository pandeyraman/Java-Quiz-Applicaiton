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
    <title>Question List</title>
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
                <ul style="list-style-type: none">
                    <li>
                        <a href="questionForm?page=questionForm" class="button special">
                            Add New Question
                        </a>
                    </li>
                </ul>
            </nav>
            <h3>Table</h3>
            <div class="table-wrapper">

                <table>

                    <thead >
                    <tr>
                        <th><h5>ID</h5></th>
                        <th><h5>Question</h5></th>
                        <th><h5>Category</h5></th>
                        <th><h5>Option 1</h5></th>
                        <th><h5>Option 2</h5></th>
                        <th><h5>Option 3</h5></th>
                        <th><h5>Option 4</h5></th>
                        <th><h5>Correct Answer</h5></th>
                        <th><h5>Edit</h5></th>
                        <th><h5>Delete</h5></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${questionList}" var="question">
                        <tr>
                            <td>${question.id}</td>
                            <td>${question.question}</td>
                            <td>${question.category}</td>
                            <td>${question.option_1}</td>
                            <td>${question.option_2}</td>
                            <td>${question.option_3}</td>
                            <td>${question.option_4}</td>
                            <td>${question.correct_ans}</td>
                               
                            <td><a href="editQuestion?page=editQuestion&id=${question.id}">Edit</a> </td>
                               
                            <td><a href="deleteQuestion?page=deleteQuestion&id=${question.id}">Delete</a> </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </section>
    </div>
</section>
</body>
</html>
