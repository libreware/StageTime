package stagetime

import stagetime.security.SessionService

class UserController {
    static scope = "prototype"
    def SessionService sessionService

    def index() {

    }

    def manageFilters(){
        def user = sessionService.getUser()
        if (params.edit == 'enabled' && params.id != null){
            // if user try to edit a filter
            if (request.method == 'POST') {
                // if a form was posted and the filter can be updated
                if (FilterService.updateFilter(params.id,params)) {
                    flash.success = "filter.update.success"
                    render(view: "viewFilter", model:[userInstance: user,
                            filterInstance: FilterService.getFilter(params.id)])
                    return true
                } else {
                    flash.error = "filter.update.failed"
                    render(view: "editFilter", model:[userInstance: user,
                                    filterInstance: FilterService.getFilter(params.id)])
                    return false
                }
            }else {
                // If the form is to be displayed
                render(view: 'editFilter', model:[userInstance: user,
                        filterInstance: FilterService.getFilter(params.id)])
            }
        } else if (params.id != null){
            render(view: 'viewFilter', model:[userInstance: user,
                    filterInstance: FilterService.getFilter(params.id)])
        }else render(view: 'myFilters', model:[userInstance: user, filterList:user.getFilters()])
    }

    def deleteFilter(){
        if (FilterService.removeFilter(params.id)){
            flash.message="filter.delete.success"
            redirect(action:"manageFilters")
            return true
        } else {
            flash.error="filter.delete.failed"
            redirect(action:"manageFilters", model:[userInstance: sessionService.getUser(),
                    filterInstance: FilterService.getFilter(params.id)])
            return false
        }

    }
}
