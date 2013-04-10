<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Bauyrzhan
  Date: 4/10/13
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ura</title>
</head>
<body>


<%--
<form:form method="POST" commandName="customerForm">
    <c:forEach items="${sz.questions}" var="question">
        <c:out value="${question.text}" /> <br/>
        <c:forEach items="${question.options}" var="option">
            <form:radiobutton path="sss" value="${option.text}" />
        </c:forEach>
        <hr/>
    </c:forEach>
</form:form>
--%>

<c:forEach items="${sz.questions}" var="question">
    <c:out value="${question.text}" />
    <c:forEach items="${question.options}" var="option">
        <c:out value="${option.text}" />
    </c:forEach>
    <hr/>
</c:forEach>


</body>
</html>