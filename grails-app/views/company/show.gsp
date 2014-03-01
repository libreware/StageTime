<%--
  Created by IntelliJ IDEA.
  User: kev
  Date: 01/03/14
  Time: 12:07
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="company.show.title" args="[company.name]"/> </title>
</head>
<body>
<div>
    <g:render template="layout/menu"></g:render>
    <a href="<g:createLink action="edit" id="${company?.id}"/>"> <g:message code="company.edit"></g:message>  </a>
    <a href="<g:createLink action="delete" id="${company?.id}"/>"> <g:message code="company.delete"></g:message>  </a>
    <div style="margin-left: 10px;margin-top: 10px">
        <p >
            <strong>
                <g:message code="company.name"/>
            </strong>
            <span>
                ${company.name}
            </span>
        </p>
        <p>
            <strong>
                <g:message code="company.size"/>
            </strong>
            <span>
                ${company.size}
            </span>
        </p>
        <p>
            <strong>
                <g:message code="company.webSite"/>
            </strong>
            <span>
                ${company.webSite}
            </span>
        </p>
    </div>
    <div style="margin-top: 15px; ">
           <div style="width: 48%; float: left">
               <h3> <g:message code="company.keywords.list" /></h3>
               <g:each var="keyword" in="${company.keywords}">
                   <div>
                       ${keyword.tag}
                   </div>
               </g:each>
           </div>
            <div style="width: 48%; float: right">
                <h3><g:message code="company.comments"/> </h3>
                <g:each var="comment" in="${company.comments}">
                    <span><g:message code="comment.poster" args="[comment.user]" /></span><br>
                    <span>
                        ${comment.content}
                    </span>
                </g:each>
            </div>
    </div>
</div>

</body>
</html>