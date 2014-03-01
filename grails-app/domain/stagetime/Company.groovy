package stagetime

class Company {
    /**
     * The company's name
     */
    String name

    /**
     * Total company size @see stagetime/CompanySize
     */
    CompanySize size

    /**
     * Company's home page
     */
    String webSite

    static hasMany = [
            /**
             * List of keywords that will help of defining the internship offer nature,
             * will be used for filter / research mechanism.
             */
            keywords:Keyword,
            /**
             * List of comments made on the company
             */
            comments:Comment,
            /**
             * List of it's employees
             */
            employees:Recruiter
    ]

    /**
     * If an object is not valid it can't be seen by any others than the administrators.
     * Once validated everyone can see it
     */
    boolean isValid = false

    /*
     * Counting the like of an offer, will allow us to compare them a bit later.
     */
    Integer popularity = 0

    static constraints = {
        name(nullable: false, blank: false)
        webSite(nullable: false, blank: false)
        size(nullable: false, blank: false)
    }
}
