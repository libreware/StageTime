package stagetime

import grails.transaction.Transactional
import groovyjarjarcommonscli.MissingArgumentException

@Transactional
class CompanyService {

    def grailsApplication
    def keywordService

   def getCompanies(int offset){
        def max = grailsApplication.config.grails.stagetime.search.max.toInteger()
        def companyCount = Company.count
        def companies = Company.list(offset: offset, max: max)
        return [companies :companies, companyCount : companyCount]
   }

    def saveCompany(Map params){
        def hasError = false
        def message = ""
        def result = [:]
        Company company
        try{
            if(params.operation){
                    switch (params.operation){
                        case "create" :
                            if(params.name && params.size && params.webSite){
                                company = new Company()
                                company.name = params.name
                                company.size = CompanySize.valueOf(params.size)
                                company.webSite = params.webSite
                                message = "company.success.create"
                            }else{
                                hasError = true
                                message = "company.exception.noArgument"
                            }
                            break
                        case "edit" :
                           if(params.companyId){
                               company = Company.get(Long.parseLong(params.companyId))
                               company.name = params.name
                               company.size = CompanySize.valueOf(params.size)
                               company.webSite = params.webSite
                               message = "company.success.update"
                           }else{
                               hasError = true
                               message = "company.exception.noArgument"
                           }
                            break
                        default : hasError = true
                                  message = "company.exception.noOperation"
                }
                try{
                    company.save(flush: true)
                }catch (Exception e){
                    hasError = true
                    message = "company.exception"
                }
            }else{
                hasError = true
                message = "company.exception"
            }
        }catch (Exception e){
            hasError = true
            message = "company.exception"
        }
        if(hasError){
           result = [error : true, message : message]
        }else{
           result = [success : true, message: message, company: company]
        }
        return result
    }


    def deleteCompany(Map params){
        def hasError = false
        def message = ""
        def result = [:]
        Company company
        try{
            if(params.id){
                company = Company.get(Long.parseLong(params.id))
                if(company){
                    company.delete()
                    message = "company.success.delete"
                }else{
                    hasError = true
                    message = "company.exception.notFound"
                }

            }else{
                hasError = true
                message = "company.exception.delete.noId "
            }
        }catch (Exception e){
                hasError = true
                message = "company.exception.delete.fail"
        }
        if(hasError){
            result = [error: true, message: message]
        }else{
            result = [success: true, message: message]
        }
        return result
    }

    def getCompany(params){
        def hasError = false
        def message = ""
        def result = [:]
        Company company
        try{
            if(params.id){
                company = Company.get(Long.parseLong(params.id))
                if(!company){
                    hasError = true
                    message = "company.exception.notFound"
                }

            }else{
                hasError = true
                message = "company.exception.noArgument"
            }
        }catch (Exception e){
            hasError = true
            message = "company.exception.get.fail"
        }
        if(hasError){
            result = [error: true, message: message]
        }else{
            result = [success: true, company: company]
        }
        return result
    }
}
