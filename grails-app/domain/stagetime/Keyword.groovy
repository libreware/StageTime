package stagetime

class Keyword {
    /**
     * The tag of the keyword (e.g. java, ssii, whatever)
     */
    String tag

    static hasMany = [

            references:Reference
    ]

    static constraints = {
        tag(nullable:false, blank: false, unique: true)
    }

    static mapping = {
        id generator:'assigned', name: 'tag'
    }
}

