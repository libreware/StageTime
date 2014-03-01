<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="company.create.title"/> </title>
</head>
<body>
<div>
    <g:render template="layout/menu"></g:render>
    <div>
        <h1><g:message code="company.create.title"/></h1>
    </div>
    <div>
        <g:render template="layout/form" model="['action':'creation']"/>
    </div>
</div>
</body>
</html>