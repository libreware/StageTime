package stagetime

class Notification {
    /**
     * The user has read the notification
     */
    boolean read = false

    /**
     * The user has seen the notification (in the notification list, but may not have read it)
     */
    boolean seen = false

    /**
     * The object that is referenced by the notification (we can get uri from it)
     */
    Reference referencedObject

    static belongsTo = User


    static constraints = {
        referencedObject(nullable: false, blank: false)
    }
}
