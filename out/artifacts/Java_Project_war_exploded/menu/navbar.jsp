<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: xmen_alive
  Date: 7/16/17
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/style_new.css" rel="stylesheet">

</head>
<body>

<header id="header">
    <h1><a href="home?page=home">Java Project</a></h1>

    <nav id="nav" class="nav-tabs-justified">
        <ul>
            <li><a href="home?page=home">Home</a></li>
            <c:if test="${sessionScope.user.role=='admin'}">
                <li><a href="userList?page=userList">User</a></li>
                <li><a href="studentList?page=studentList">Student</a></li>
                <li><a href="questionList?page=questionList">Question</a></li>

            </c:if>
            <li>
                <a href="getQuestion?page=quiz&id=0" class="button special" style="background:lightseagreen">Play Quiz</a>
            </li>
            <li><a href="logout?page=logout" class="button special">Log Out</a></li>
        </ul>
    </nav>
</header>


</body>
</html>
