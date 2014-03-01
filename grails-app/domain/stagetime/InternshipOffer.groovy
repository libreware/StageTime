package stagetime

class InternshipOffer {
    /**
     * The title of the offer that describes briefly the topic of the internship
     */
    String title

    /**
     * Local location of the file that describe precisely the Internship offer.
     * Must be PDF format file.
     */
    String uri

    /**
     * The address of the place where the internship takes place
     */
    String workingLocation

    /**
     * Month net effective salary in euros representing the amount of money the
     * student will receive every month on his bank account.
     */
    Float salary

    /**
     * Today's date means as soon as possible
     */
    Date begin

    /**
     * Internship month duration
     */
    Integer monthDuration

    /**
     * Working space defines the working context, such as an office,
     * an open-space or telecommuting
     */
    WorkingSpace workingSpace

    /**
     * Contract type of the internship
     */
    InternshipType internshipType

    /*
     * Counting the like of an offer, will allow us to compare them a bit later.
     */
    Integer popularity = 0

    /**
     * The internship tutor name (may evolve into a user id
     * if the tutor becomes a user in the system)
     */
    String tutor

    /**
     * The person that created the offer
     * A manager may have to create an offer and so there must be an interface that
     * enables him/her to add a recruiter to the offer or create it if it doesn't exist yet.
     */
    static belongsTo = Recruiter

    static hasMany = [
            /**
             * List of keywords that will help of defining the internship offer nature,
             * will be used for filter / research mechanism.
             */
            keywords:Keyword,
            /**
             * The users that have applied to offer
             */
            appliants:User
    ]

    /**
     * If an object is not valid it can't be seen by any others than the administrators.
     * Once validated everyone can see it
     */
    boolean isValid = false

    static constraints = {
        title(nullable:false, blank: false)
        uri(nullable:false, blank: false, unique: true)
        salary(nullable:false, blank: false)
        begin(nullable:false, blank: false)
        monthDuration(nullable:false, blank: false)
        workingSpace(nullable:false, blank: false)
        internshipType(nullable:false, blank: false)
        workingLocation(nullable:false, blank: false)
        tutor(nullable:true, blank: true)
    }
}