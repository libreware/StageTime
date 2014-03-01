<%--
  Created by IntelliJ IDEA.
  User: kev
  Date: 01/03/14
  Time: 11:17
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="company.edit.title"/></title>
</head>

<body>
    <g:render template="layout/menu"></g:render>
    <g:render template="layout/form" model="['action':'edit', 'company' : company]"/>
</body>
</html>