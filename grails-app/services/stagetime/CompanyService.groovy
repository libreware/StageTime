package stagetime

import grails.transaction.Transactional

@Transactional
class CompanyService {

    static Company getCompany(long id) {
        return Company.get(id)
    }

    static boolean createCompany(Company company) {
        return company.save(flush: true)
    }
}
