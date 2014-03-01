package stagetime

import grails.transaction.Transactional

@Transactional
class CompanyService {

    def serviceMethod() {

    }

    Company getCompany(long id) {
        return Company.get(id)
    }

    boolean createCompany(Company company) {
        return company.save(flush: true)
    }
}
