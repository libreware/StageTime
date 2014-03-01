package stagetime

import stagetime.security.SimpleSecService

class UserController {

    /**
     * List entities
     */
    def index() { }

    /**
     * Get given entity
     * @param id
     */
    def get(Long id){

    }

    /**
     * Generate view for creating new entity
     */
    def create() {

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

        if(!params.id){

            if(params.password == params.passwordConfirm) {
                params.hashedPassword = SimpleSecService.encrypt(params.password)

                def saveResult

                switch(params.type) {
                    case 'student':
                        user = new Student(params)
                        saveResult = UserService.createStudent(user, true)
                        break;
                    case 'teacher':
                        user = new Teacher(params)
                        saveResult = UserService.createTeacher(user, true)
                        break;
                    case 'recruiter':
                        user = new Recruiter(params)
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
                            } else if(!sizeDefined){
                                flash.error = 'company.create.error.size'
                            }
                        } else {
                            flash.error = 'user.create.error.company'
                        }
                        break;
                    default: break;
                }

                if(!saveResult){
                    flash.error = 'user.create.error'
                }

            } else {
                flash.error = 'user.create.error.password'
            }
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

}
