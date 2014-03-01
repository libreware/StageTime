package stagetime

import grails.transaction.Transactional
import javassist.NotFoundException
import stagetime.security.SimpleSecService

@Transactional
class UserService {


    static def createStudent(Student student, boolean fromAdministrator){
        createUser(student)
    }

    static def createTeacher(Teacher teacher, boolean fromAdministrator){
        createUser(teacher)
    }

    static def createRecruiter(Recruiter recruiter, Company company, boolean fromAdministrator){
        createUser(recruiter)
        company.addToEmployees(recruiter)
        recruiter.save(flush: true)
    }

    static private boolean createUser(User user, boolean fromAdministrator){
        if(fromAdministrator){
            // Enable by default
            user.isValid = true
        }
        user.save(flush: true)
    }

}
