package stagetime

import grails.transaction.Transactional
import javassist.NotFoundException
import stagetime.security.SimpleSecService

@Transactional
class UserService {


    def createStudent(Student student, boolean fromAdministrator){
        createUser(student)
    }

    def createTeacher(Teacher teacher, boolean fromAdministrator){
        createUser(teacher)
    }

    def createRecruiter(Recruiter recruiter, Company company, boolean fromAdministrator){
        createUser(recruiter)
        company.addToEmployees(recruiter)
        recruiter.save(flush: true)
    }

    private boolean createUser(User user, boolean fromAdministrator){
        if(fromAdministrator){
            // Enable by default
            user.isValid = true
        }
        user.save(flush: true)
    }

    /**
     * Create a user
     * @param params
     * @param fromAdministrator
     */
    def xcreateUser(Map params, boolean fromAdministrator){

        def user
        def company

        switch(params.type) {
            case 'student':

                user = new Student()

                break;
            case 'teacher':

                user = new Teacher()
                user.isManager = (params.isManager == 'true')

                break;

            case 'recruiter':

                user = new Recruiter()
                user.job = params.job

                if(!params.company)
                    throw new IllegalArgumentException('user.create.error.company.empty')

                if(params.company.long('id')){
                    company = Company.get(params.company.long('id'))
                    if(!company)
                        throw new NotFoundException('company.error.notfound')
                } else {
                    // We create company now
                    company = new Company()
                    company.name = params.company.name
                    // Check company size
                    switch(params.company.size){
                        case 'TPE': company.size = CompanySize.TPE; break;
                        case 'PME': company.size = CompanySize.PME; break;
                        case 'TPE': company.size = CompanySize.ETI; break;
                        case 'TPE': company.size = CompanySize.GE; break;

                        default:
                            throw new IllegalArgumentException('company.create.error.size')
                    }
                    company.webSite = params.company.webSite
                    company.save(flush: true)

                }

                break;

            default: throw new IllegalArgumentException('user.create.error.type')
        }

        if(fromAdministrator){
            // Enable by default
            user.isValid = true
        }


        if(params.password != params.passwordConfirm)
            throw new IllegalArgumentException('user.create.error.passwordConfirm')

        user.hashedPassword = SimpleSecService.encrypt(params.password)
        user.firstName = params.firstName
        user.secondName = params.secondName
        user.email = params.email
        user.phoneNumber = params.phoneNumber

        user.save(flush: true)

        if(user instanceof Recruiter){
            company.addToEmployees(user)
            company.save(flush: true)
        }



    }
}
