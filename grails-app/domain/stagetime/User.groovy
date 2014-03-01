package stagetime

/**
 * Abstract domain user class. Only used for inheritance.
 * Should not be modified.
 */
abstract class User {

    /**
     * First name of the user (familly name)
     */
    String firstName
    /**
     * User's second name
     */
    String secondName
    /**
     * User's email address (is used for login)
     */
    String email
    /**
     * User password (hashed)
     */
    String hashedPassword
    /**
     * User's phone number (not mandatory
     */
    String phoneNumber

    static hasMany = [
            /*
             * List of keywords and comments written by the user, will allow us
             * to let the user modify and remove his comment. Paternity concept.
             */
            comments:Comment,
            /**
             * The users notifications
             */
            notifications:Notification,
            /*
             * List of filters that will notice users of corresponding internship offers.
             * WARNING : We have two convenient filter that store some specific offers for student:
             * Favorite filter : store each favorite offers id
             * Appliance filter : store each offers id for which the user has apply
             */
            filters:Filter
    ]

    /**
     * If an object is not valid it can't be seen by any others than the administrators.
     * Once validated everyone can see it
     */
    boolean isValid = false

    @Override
    String toString() {
        return (firstName + " " + secondName)
    }

    static constraints = {
        firstName(size: 2..20, blank: false, matches: "[a-zA-Z]+")
        secondName(size: 2..20, blank: false, matches: "[a-zA-Z]+")
        email(email:true, nullable:false, blank: false, unique: true)
        hashedPassword(nullable:false, blank: false)
        phoneNumber(nullable:true, blank: true)
    }
}
