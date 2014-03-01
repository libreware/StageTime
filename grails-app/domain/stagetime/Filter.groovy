package stagetime

class Filter {

    /**
     * Name has to be unique for each user which mean
     * two filters related to a user cannot have the same name : TODO: create a special constraint
     * Warning : Though there is two reserved that a user can't use for a filter : favorite and appliance
     * there are actually used by the system to keep track of them in a specific manner.
     */
    String name

    /**
     * Is the filter taken into account for user notification
     */
    boolean enabled = true

    /**
     * Will send an email to the user at each notification
     */
    boolean mailNotification = false

    /**
     * will notify the user, according to the selected mean
     */
    boolean notifyOnComment = false

    /**
     * How to notify the user when a comment is made on objects matching the filter
     */
    boolean mailOnComment = false

    static hasMany = [
            /**
             * List of keywords that will be used to perform the research (automatic one) and notified
             * users if it match with their expectations.
             */
            keywords:Keyword
    ]

    /**
     * Owner of the filter, person to be notified when a new matching offer appear
     */
    static belongsTo = [user:User]

    // Make sure one user can't have filters with the same name !
    static constraints = {

        name validator: { val, obj ->
            for (Filter f : obj.user.filters) {
                if (f.name == val) return false;
            }
            return true;
        }
        name(nullable:false, blank: false, unique: false)
    }
}
