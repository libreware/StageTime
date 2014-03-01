package stagetime

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FilterService)
@Mock([User, Keyword, Student, Filter])
class FilterServiceSpec extends Specification {

    //@Unroll
    void "A student filter creation "() {

        given: "A mocked user and keywords"
        GroovyMock(Student, global:true)
        GroovyMock(Filter, global:true)
        Student student = Mock()
        Filter filter = Mock()

        and:
        (0..1) * student.save(_) >> true
        (0..1) * student.attach() >> student
        (0..1) * student.isAttached() >> true
        (0..1) * filter.validate() >> true
        (0..1) * student.addToFilters(_) >> true

        expect:
        FilterService.createFilter(filter, student)
    }

    @Unroll
    void "Filter update"() {
        given: "A mocked user and keywords"
        GroovyMock(Filter, global:true)
        Filter filter = Mock()
        def params = []

        and:
            1 * Filter.get(_) >> filter
            1 * filter.validate() >> validateSuccess
        (0..1) * filter.merge(_) >> filter

        expect:
            FilterService.updateFilter(1, params) == expectedResult

        where:
            validateSuccess    | expectedResult
            true               | true
            false              | false
    }
    @Unroll
    void "Filter Removing"() {

        given:
        boolean ret
        GroovyMock(Filter, global:true)
        Filter filter = Mock()

        and:
        1 * Filter.get(_) >> filter
        (0..1) * filter.delete() >> true
        (1..2) * filter.getName() >> name

        try {
            ret = FilterService.removeFilter(1)
        }
        catch (IllegalArgumentException ex) {
            ret = false;
        }
        expect:
            ret == expectedReturn

        where:
            name                    | expectedReturn
            "bla"                   | true
            "Favoris"               | false
            "Candidatures"          | false
    }
}
