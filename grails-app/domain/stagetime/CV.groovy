package stagetime

class CV {
    /**
     * Address of the CV on the local file system
     */
    String uri

    /**
     * CV's status (is allowed to be seen by others or not)
     */
    boolean isPubished

    static hasMany = [
            /**
             * List of it's keywords
             */
            keywords:Keyword,
            /**
             * List of the comments made on the CV
             */
            comments:Comment
    ]

    // defines the object visibility
    boolean isVisibleToTeacher = false
    boolean isVisibleToRecruiter = false
    boolean isVisibleToStudents = false

    static constraints = {
        uri(nullable:false, blank: false, unique: true)
    }
}
