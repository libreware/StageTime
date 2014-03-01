<%--
  Created by IntelliJ IDEA.
  User: kev
  Date: 01/03/14
  Time: 12:06
--%>

<%@ page import="stagetime.Company" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>
<body>
    <div>
        <g:render template="layout/menu"></g:render>
        <div>
            <h3><g:message code="company.list.head" args="[companyCount?:0]"/></h3>
            <table>
                <thead>
                    <th>
                        <g:message code="company.name"/>
                    </th>

                <th>
                    <g:message code="company.size"/>
                </th>

                <th>
                    <g:message code="company.webSite"/>
                </th>
                <th>

                </th>
                <th>

                </th>
                <th>

                </th>
                </thead>
                <tbody>
                    <g:each var="lignes" in="${companies}">
                        <tr>
                            <td>
                                ${lignes.name}
                            </td>
                            <td>
                                ${lignes.size}
                            </td>
                            <td>
                                ${lignes.webSite}
                            </td>
                            <td>
                                <a href="<g:createLink action="show" id="${lignes.id}" />"> <g:message code="company.show.go" args="[lignes.name]"></g:message>  </a>
                            </td>
                            <td>
                                <a href="<g:createLink action="edit" id="${lignes.id}"/>"> <g:message code="company.edit"></g:message>  </a>
                            </td>
                            <td>
                                <a href="<g:createLink action="delete" id="${lignes.id}"/>"> <g:message code="company.delete"></g:message>  </a>
                            </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>