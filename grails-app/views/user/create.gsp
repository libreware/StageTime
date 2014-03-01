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

        <fieldset id="formUser">
            <legend><g:message code="default.form.title.user.main" /></legend>
            <g:render template="formUser" />
        </fieldset>


		<fieldset id="formCompany">
			<legend><g:message code="default.form.title.recruiter" /></legend>
			<g:render template="recruiterForm" />
		</fieldset>

		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-premary" >
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