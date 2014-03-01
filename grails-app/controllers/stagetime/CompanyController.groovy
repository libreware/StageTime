package stagetime

class CompanyController {


    def companyService

    def index(){
        redirect(action: "list")
    }

    def create(){
        def types = CompanySize.values()
        render( view: "create", model: [types: types])
    }

    def list(){
        def result = companyService.getCompanies(params.offset?:0)
        render view: "list", model: [companies: result.companies, companyCount : result.companyCount]
    }

    def show(){
        def result = companyService.getCompany(params)
        def company
        if(result.error){
            flash.error = result.message
            redirect(action: "list")
        }else{
            flash.success = result.message
            company = result.company
            render view: "show", model: [company : company]
        }
        return
    }

    def edit(){
        def types = CompanySize.values()
        def result = companyService.getCompany(params)
        def company
        if(result.error){
            flash.error = result.message
            redirect(action: "list")
        }else{
            flash.success = result.message
            company = result.company
            render view: "edit", model: [company : company, types: types]
        }
        return
    }

    def save(){
        def result = companyService.saveCompany(params)
        def company
        if(result.error){
            flash.error = result.message
            redirect(url: request.getHeader('referer'))
        }else{
            flash.success = result.message
            company = result.company
            render view: "show", model: [company : company]
        }
        return
    }

    def delete(){
        def result = companyService.deleteCompany(params)
        if(result.error){
            flash.error = result.message
            redirect(url: request.getHeader('referer'))
        }else{
            flash.success = result.message
            redirect(action: "list")
        }
        return
    }
}
