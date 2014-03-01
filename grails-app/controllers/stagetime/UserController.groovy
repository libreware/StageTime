package stagetime

class UserController {

    static scope = "prototype"

    def SessionService sessionService

    /**
     * List entities
     */
    def index() { }

    /**
     * Get given entity
     * @param id
     */
    def show(Long id){

        def user = User.get(id)

        render view: 'show', model:[user: user]
    }

    /**
     * Generate view for creating new entity
     */
    def create() {

        render view: 'create', model:[companiesList: []]
    }

    /**
     * generate view for editing given entity
     * @param id
     */
    def edit(Long id) {

    }

    /**
     * Create or update entity
     */
    def save() {

        def user

        if(request.method == 'POST'){

            println params

            if(!params.id){

                def saveResult

                switch(params.type) {
                    case 'student':
                        user = new Student(params)
                        savePassword(user, params.password, params.passwordConfirm)
                        saveResult = handlerSaveStudent(user)
                        break;
                    case 'teacher':
                        user = new Teacher(params)
                        savePassword(user, params.password, params.passwordConfirm)
                        saveResult = handlerSaveTeacher(user)
                        break;
                    case 'recruiter':
                        user = new Recruiter(params)
                        savePassword(user, params.password, params.passwordConfirm)
                        saveResult = handlerSaveRecruiter(user)
                    default: break;
                }

                if(saveResult){
                    redirect action: 'show', id: user.getId()
                    return true
                }

            } else {
                // TODO: update user
            }
        }

        flash.error = 'user.create.error'
        render view: 'create', model:[user: user, companiesList: []]
    }

    private boolean savePassword(User user, String password1, String password2){
        if(password1 != password2 || password1 == ''){
            user.errors.rejectValue('hashedPassword', 'user.create.error.passwordConfirm')
            return false
        } else {
            user.hashedPassword = password1
            return true
        }
    }

    /**
     * Delete entity defined by the given id
     * @param id
     */
    def delete(Long id){

    }

    private boolean handlerSaveStudent(Student user) {
        return UserService.createStudent(user, true) // TODO: parameter
    }

    private boolean handlerSaveTeacher(Teacher user){
        return UserService.createTeacher(user, true) // TODO: parameter
    }

    private boolean handlerSaveRecruiter(Recruiter user){
        return UserService.createRecruiter(user, true) // TODO: parameter
    }

    def manageFilters(){
        def user = sessionService.getUser()
        if (params.edit == 'enabled' && params.id != null){
            // if user try to edit a filter
            if (request.method == 'POST') {
                // if a form was posted and the filter can be updated
                if (FilterService.updateFilter(params.id,params)) {
                    flash.success = "filter.update.success"
                    render(view: "viewFilter", model:[userInstance: user,
                            filterInstance: FilterService.getFilter(params.id)])
                    return true
                } else {
                    flash.error = "filter.update.failed"
                    render(view: "editFilter", model:[userInstance: user,
                                    filterInstance: FilterService.getFilter(params.id)])
                    return false
                }
            }else {
                // If the form is to be displayed
                render(view: 'editFilter', model:[userInstance: user,
                        filterInstance: FilterService.getFilter(params.id)])
            }
        } else if (params.id != null){
            render(view: 'viewFilter', model:[userInstance: user,
                    filterInstance: FilterService.getFilter(params.id)])
        }else render(view: 'myFilters', model:[userInstance: user, filterList:user.getFilters()])
    }

    def deleteFilter(){
        if (FilterService.removeFilter(params.id)){
            flash.message="filter.delete.success"
            redirect(action:"manageFilters")
            return true
        } else {
            flash.error="filter.delete.failed"
            redirect(action:"manageFilters", model:[userInstance: sessionService.getUser(),
                    filterInstance: FilterService.getFilter(params.id)])
            return false
        }
    }
}
