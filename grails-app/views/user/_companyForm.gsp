<%@page import="stagetime.CompanySize"%>
<div>
	<div class="form-group">
		<label for="job" class="col-sm-2 control-label"><g:message
				code="default.form.company.job" /></label>
		<div class="col-sm-10">
			<input type="text" name="job" class="form-control" id="job" value="${ params?.job }"/>
		</div>
	</div>
	<div class="form-group">
		<label for="companyName" class="col-sm-2 control-label"><g:message
				code="default.form.title.company" /></label>
		<div class="col-sm-8">
			<g:select name="companyName" from="${ companiesList }" class="form-control" value="${ params?.companyName }" id="companyName"/>
		</div>
		<div class="col-sm-2">
			<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span>&nbsp;<g:message code="default.form.compny.add" /></button>
		</div>
	</div>
</div>