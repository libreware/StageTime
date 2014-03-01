package stagetime

import grails.transaction.Transactional
import javassist.NotFoundException
import stagetime.security.SimpleSecService

@Transactional
class UserService {


    static def createStudent(Student student, boolean fromAdministrator){
        createUser(student, fromAdministrator)
    }

    static def createTeacher(Teacher teacher, boolean fromAdministrator){
        createUser(teacher, fromAdministrator)
    }

    static def createRecruiter(Recruiter recruiter, boolean fromAdministrator){
        createUser(recruiter, fromAdministrator)
    }

    static private boolean createUser(User user, boolean fromAdministrator){
        if(fromAdministrator){
            // Enable by default
            user.isValid = true
        }
        user.save(flush: true)
    }

}
