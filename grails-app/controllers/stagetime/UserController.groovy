package stagetime

import stagetime.security.SimpleSecService

class UserController {

    private final static REDIRECT_CREATE = 'create'

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

        render view: 'create', model:[params: params, companiesList: [new Company(name: 'company 1'), new Company(name: 'company 1')]]
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

        println params

        if(!params.id){

            if(params.password == params.passwordConfirm) {
                params.hashedPassword = SimpleSecService.encrypt(params.password)
                params.password = ''
                params.passwordConfirm = ''

                def saveResult

                switch(params.type) {
                    case 'student':
                        user = new Student(params)
                        handlerSaveStudent(user)
                        break;
                    case 'teacher':
                        user = new Teacher(params)
                        saveResult = handlerSaveTeacher(user)
                        break;
                    case 'recruiter':
                        user = new Recruiter(params)
                        saveResult = handlerSaveRecruiter(user, params)
                    default: break;
                }

                if(!saveResult){
                    flash.error = 'user.create.error'
                    redirect action: REDIRECT_CREATE
                    return false
                } else {
                    flash.message = 'user.create.success'
                    redirect action: 'show', id: user.getId()
                    return
                }

            } else {
                flash.error = 'user.create.error.password'
                params.password = ''
                params.passwordConfirm = ''
                redirect action: REDIRECT_CREATE, params: params
                return false
            }

            redirect action: REDIRECT_CREATE
        } else {
            // TODO: update user
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

    private boolean handlerSaveRecruiter(Recruiter user, Map params){

        def saveResult = false
        if(params.company){
            def company
            def companyDefined = true
            def sizeDefined = true
            if(params.company.long('id')){
                company = CompanyService.getCompany(params.company.long('id'))
            } else {
                company = new Company(params.company)
                switch(params.company.size){
                    case 'TPE': company.size = CompanySize.TPE; break
                    case 'PME': company.size = CompanySize.PME; break
                    case 'TPE': company.size = CompanySize.ETI; break
                    case 'TPE': company.size = CompanySize.GE; break
                    default: sizeDefined = false
                }
                if(sizeDefined){
                    if(!CompanyService.createCompany(company)){
                        companyDefined = false
                    }
                }
            }
            if(companyDefined && sizeDefined){
                saveResult = UserService.createRecruiter(user, company, true)
            } else if(!companyDefined){
                flash.error = 'company.create.error'
                redirect action: REDIRECT_CREATE
                return false
            } else if(!sizeDefined){
                flash.error = 'company.create.error.size'
                redirect action: REDIRECT_CREATE
                return false
            }
        } else {
            flash.error = 'user.create.error.company'
            redirect action: REDIRECT_CREATE
            return false
        }

        return saveResult
    }



}
