package stagetime

import stagetime.security.SessionService

class UserController {

    def SessionService sessionService

    def index() {

    }

    def manageFilters(){
        // Afficher tous les filtres
        // edit id
        if (params.edit == 'enabled' && params.id != null){
            if (request.method == 'POST') {

            }
            render(view: 'editFilter', model:[userInstance: sessionService.getUser(),
                    filterInstance: FilterService.getFilter(params.id)])
        }

        render(view: 'myFilters', model:[userInstance: sessionService.getUser()])
    }
}
