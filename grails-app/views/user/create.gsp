<html>
<head>
<meta name="layout" content="main">
<title><g:message code="default.form.title.createuser" /></title>
</head>
<body>
	<h1>
	<g:message code="default.form.title.createuser"/>
	</h1>
	<g:form class="form-horizontal" action="create" role="form">
		<g:render template="formUser" />
		<div class="form-group"></div>
		<h1><g:message code="default.form.title.company" /></h1>
		<g:render template="companyForm" />
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" >
				<g:message code="default.form.submit" />
			</button>
		</div>
	</g:form>
</body>
</html>