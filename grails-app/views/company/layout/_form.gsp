<%@ page import="stagetime.CompanySize" %>
<g:form method="POST" controller="company" action="save">
    <div>
        <g:hiddenField name="operation" value="${action == 'creation'?'create':'edit'}"/>
        <g:hiddenField name="companyId" value="${company?.id}"/>
        <p><span><g:message code="company.name"></g:message> </span><g:field type="text" name="name" min="1"  required="" value="${company?.name}"/></p>
        <p><span><g:message code="company.size"></g:message>
            <g:select name="size"
                      from="${types}"
                      value="${company?.size?.toString()}"
                      optionKey="${company?.size?.name()}"
                       />
        </span></p>
        <p><span><g:message code="company.webSite"></g:message> <g:field type="url" name="webSite" required="" value="${company?.webSite}" /></span></p>
    </div>
    %{--<div id="keywords">
        <g:each var="keyword" in="${company?.keywords}">
             <g:field type="text" value="${keyword.id}"/><button><g:remoteLink controller="keyword" action="deassociateKeyword"  params="[entity : '']"  </button>
        </g:each>
        <g:field type="text"  id="addKeyword"/><button type="button" onclick="addKeyword()"></button>
    </div>--}%
    <g:submitButton name="${action == 'creation'?'create':'update'}"/>
</g:form>



<script>
</script>