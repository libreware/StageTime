package stagetime

class Recruiter extends User{
    /**
     * The recruiter's job in the company
     */
    String job

    static hasMany = [
            /**
             * The internships he offers
             */
            internshipOffers:InternshipOffer
    ]

    /**
     * The company he works for
     */
    static belongsTo = [company: Company]

    static constraints = {
        company nullable: true
        job(nullable: false, blank: false)
    }
}
