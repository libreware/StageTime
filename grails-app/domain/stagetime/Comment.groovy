package stagetime

class Comment {
    /**
     * The comment content (the message left by the user)
     */
    String content

    /**
     * References the person that created the comment
     */
    static belongsTo =  User

    /**
     * Concerned object
     */
    Reference referencedObject

    static constraints = {
        referencedObject(nullable: false, blank: false)
        content(nullable: false, blank: false)
    }
}
