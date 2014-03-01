package stagetime

class Student extends User {

    /*
     * Curriculum of the student (PDF format)
     */
    CV cv

    static hasOne = [
            /**
             * The teacher that follows this student
             */
            tutor:Teacher
    ]

    static constraints = {
    }
}
