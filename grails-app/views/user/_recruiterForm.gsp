<div>
	<div class="form-group ${ user?.errors?.getFieldError('job') ? 'has-error' : '' }">
		<label for="job" class="col-sm-2 control-label"><g:message
				code="default.form.company.job" /></label>
		<div class="col-sm-10">
			<input type="text" name="job" class="form-control" id="job" value="${ params?.job }"/>
		</div>
	</div>

</div>