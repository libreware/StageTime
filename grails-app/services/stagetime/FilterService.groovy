package stagetime

import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class FilterService {
    public static boolean createFilter(Filter filter, user) {
        if (!filter.validate()) {
            return false
        }

        if (!user.isAttached()) {
            user = user.attach()
        }

        return user.addToFilters(filter)
    }

    public static boolean updateFilter(long filterId, def params){
        Filter filter = Filter.get(filterId)

        filter.setProperties(params)
        if (!filter.validate()) return false

        filter = filter.merge(flush:true,failOnError: true)
        return (filter != null)
    }

    public static boolean removeFilter(long filterId) throws IllegalArgumentException{
        Filter filter = Filter.get(filterId)
        if (filter.getName() == "Favoris" || filter.getName() == "Candidatures") {
            throw new IllegalArgumentException("Cannot delete favorites or appliances filters.")
        }
        if (filter == null) return false

        filter.delete(flush: true)
        return true
    }

    public static Filter getFilter(int id){
        return Filter.get(id)
    }
}
