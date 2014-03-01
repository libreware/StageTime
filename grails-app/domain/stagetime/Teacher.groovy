package stagetime

class Teacher extends User{

    static hasMany = [
            /**
             * The users that this teacher follows
             */
            followed :User
    ]
    /**
     * Manager role
     */
    boolean isManager = false

    static constraints = {
    }
}
