package stagetime

/**
 * This is an abstraction to reference an entity without caring about his
 * type. It enables you to get the object from the database or simply get
 * a link to a page that displays this entity without knowing what kind of
 * object it is.
 */
class Reference {
    /**
     * The Types objects can be (concrete classes)
     */
    enum ObjectType {
        COMMENT,
        COMPANY,
        CV,
        FILTER,
        INTERNSHIP_OFFER,
        KEYWORD,
        NOTIFICATION,
        RECRUITER,
        STUDENT,
        TEACHER,

        /**
         * Returns the name (first letter uppercase rest lowercase)
         * @return the name
         */
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }

    }

    /**
     * The object type
     */
    public ObjectType objectType

    /**
     * The object id
     */
    public Integer objectID

    Reference(ObjectType objectType, Integer objectID) {
        this.objectType = objectType
        this.objectID = objectID
    }

    /**
     * Returns the address of the pages that displays this entity
     * @return the uri for displaying this entity
     */
    public getUri(){
        return "/" + objectType.toString() + "/" + objectID.toString()
    }

    /**
     * May seem ugly but it's clean !
     * @return the instance of the referenced object
     */
    public getInstance(){
        switch (this.objectType) {
            case ObjectType.COMMENT:
                return Comment.get(objectID)
            case ObjectType.COMPANY:
                return Company.get(objectID)
            case ObjectType.CV:
                return CV.get(objectID)
            case ObjectType.FILTER:
                return Filter.get(objectID)
            case ObjectType.INTERNSHIP_OFFER:
                return InternshipOffer.get(objectID)
            case ObjectType.KEYWORD:
                return Keyword.get(objectID)
            case ObjectType.NOTIFICATION:
                return Notification.get(objectID)
            case ObjectType.RECRUITER:
                return Recruiter.get(objectID)
            case ObjectType.STUDENT:
                return Student.get(objectID)
            case ObjectType.TEACHER:
                return Teacher.get(objectID)
        }
        return null
    }

    String getObjectType() {
        return objectType
    }

    void setObjectType(String objectType) {
        this.objectType = objectType
    }

    Integer getObjectID() {
        return objectID
    }

    void setObjectID(Integer objectID) {
        this.objectID = objectID
    }
}
