package stagetime

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CompanyService)
@Mock([Company])
class CompanyServiceSpec extends Specification {

    @Shared
    CompanyService companyService

    def setup() {
    }

    def cleanup() {
    }

    void "Company are well retreived"() {

        given: "A company"

        Company.get(_) >> companyReturned

        expect:
        companyService.getCompany(company.id) == companyExcepted

        where:
        companyReturned | companyExcepted
        new Company()   | new Company()
        null            | null


    }
}
