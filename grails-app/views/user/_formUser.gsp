<div>
	<div class="form-group ${ user?.errors?.getFieldError('firstName') ? 'has-error' : '' }">
		<label for="firstName" class="col-sm-2 control-label"><g:message
				code="default.form.name" /></label>
		<div class="col-sm-10">
			<input type="text" name="firstName" class="form-control" id="firstName" value="${ user?.firstName }"/>
		</div>
	</div>
	<div class="form-group ${ user?.errors?.getFieldError('secondName') ? 'has-error' : '' }">
		<label for="secondName" class="col-sm-2 control-label"><g:message
				code="default.form.secondname" /></label>
		<div class="col-sm-10">
			<input type="text" name="secondName" class="form-control" id="secondName" value="${ user?.secondName }"/>
        </div>
	</div>
	<div class="form-group ${ user?.errors?.getFieldError('hashedPassword') ? 'has-error' : '' }">
		<label for="password" class="col-sm-2 control-label"><g:message
				code="default.form.password" /></label>
		<div class="col-sm-10">
			<input type="password" name="password" class="form-control" id="password" value="${ params?.password }" autocomplete="off"/>
		</div>
	</div>
	<div class="form-group">
		<label for="passwordConfirm" class="col-sm-2 control-label"><g:message
				code="default.form.passwordConfirm" /></label>
		<div class="col-sm-10">
			<input type="password" name="passwordConfirm" class="form-control" id="passwordConfirm" value="${ params?.passwordConfirm }" autocomplete="off"/>
		</div>
	</div>
	<div class="form-group ${ user?.errors?.getFieldError('email') ? 'has-error' : '' }">
		<label for="email" class="col-sm-2 control-label"><g:message
				code="default.form.email" /></label>
		<div class="col-sm-10">
			<input type="email" name="email" class="form-control" id="email" value="${ user?.email }"/>
		</div>
	</div>
	<div class="form-group ${ user?.errors?.getFieldError('phoneNumber') ? 'has-error' : '' }">
		<label for="phoneNumber" class="col-sm-2 control-label"><g:message
				code="default.form.phone" /></label>
		<div class="col-sm-10">
			<input type="number" name="phoneNumber" class="form-control" id="phoneNumber" value="${ user?.phoneNumber }"/>
		</div>
	</div>
	<div class="form-group">
		<label for="accountType" class="col-sm-2 control-label"><g:message
				code="default.form.accountType" /></label>
		<div class="col-sm-10">
			<select class="form-control" id="accountType" name="type">
				<option value="teacher" ${ params?.type == "teacher" ? 'selected="selected"' : '' } ><g:message code="default.form.select.teacher" /></option>
				<option value="student" ${ params?.type == "student" ? 'selected="selected"' : '' }><g:message code="default.form.select.student" /></option>
				<option value="recruiter" ${ params?.type == "recruiter" ? 'selected="selected"' : '' }><g:message code="default.form.select.recruiter" /></option>
			</select>
		</div>
	</div>
</div>