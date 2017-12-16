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
                <ul style="list-style-type: none">
                    <li>
                        <a href="studentForm?page=studentForm" class="button special">
                            Add New Student
                        </a>
                    </li>
                </ul>
            </nav>
            <h3>Table</h3>
            <div class="table-wrapper">

                <table>

                    <thead >
                    <tr>
                        <th><bold>ID</bold></th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Roll</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${studentList}" var="student">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.firstname}</td>
                               
                            <td>${student.lastname}</td>
                               
                            <td>${student.roll}</td>
                               
                            <td><a href="editStudent?page=edit&id=${student.id}">Edit</a> </td>
                               
                            <td><a href="deleteStudent?page=deleteStudent&id=${student.id}">Delete</a> </td>
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
