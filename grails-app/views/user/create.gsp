<html>
<head>
<meta name="layout" content="main">
<title><g:message code="default.form.title.createuser" /></title>
</head>
<body>
	<h1>
	<g:message code="default.form.title.createuser"/>
	</h1>
	<g:form class="form-horizontal" action="save" role="form">
		<g:render template="formUser" />
		<div class="form-group"></div>
		<div id="formCompany">
			<h1><g:message code="default.form.title.company" /></h1>
		
			<g:render template="companyForm" />
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" >
				<g:message code="default.form.submit" />
			</button>
		</div>
	</g:form>
	<script>
		$(document).ready(function(){
			$("#formCompany").hide();
			displayFormForUserType( $("#accountType").val() );
			
			$("#accountType").change( function(){
				displayFormForUserType( $("#accountType").val() );
			});

			function displayFormForUserType( type ) {
				console.log( type );
				if( type == "recruiter" ) {
					$("#formCompany").slideDown( 400 );
				}
				else {
					$("#formCompany").slideUp( 400 );
				}

				
			}
		});
	</script>
</body>
</html>