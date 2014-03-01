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


    def setup() {
    }

    def cleanup() {
    }

    void "Company are well retreived"() {
        given: "A company"
        GroovyMock(Company, global: true)
        Company company = Mock()

        and:
        1 * Company.get(_) >> company

        expect:
        CompanyService.getCompany(0) == company

    }
}
