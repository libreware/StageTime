package stagetime

import grails.transaction.Transactional

@Transactional
class FilterService {
    public boolean createFilter(String name, user, List<Keyword> keywords) {
        Filter filter = new Filter(
                keywords: keywords, name: name,
                mailOnComment: false, notifyOnComment: false,
                mailNotification: false, enabled: true)

        if (!filter.validate()) return false

        if (!user.isAttached()) {
            user.attach()
        }
        user.addToFilters(flush:true, filter)
    }

    public boolean updateFilter(long filterId, Map<String,Object> params){
        Filter filter = Filter.get(filterId)

        filter.setProperties(params)
        if (!filter.validate()) return false

        filter = filter.merge(flush:true,failOnError: true)
        return (filter != null)
    }

    public boolean removeFilter(long filterId){
        Filter filter = Filter.get(filterId)
        if (filter == null) return false
        filter.delete(flush: true)
    }

    public static Filter getFilter(int id){
        return Filter.get(id)
    }
}
