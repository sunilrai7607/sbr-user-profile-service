package com.sbr.platform.rest.api

import com.sbr.platform.rest.api.model.response.UserResponse
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTestSpec extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    def "getUser_returnUserDetails"() {

        given: "Mock the user by userId"
//        employeeRepository.findByName(*_) >> employee
//        employee.getName() >> "John"

        when: "call the getUser"
        def response = testRestTemplate.getForEntity("/users/test", UserResponse.class)

        then: "Validate the userId"
        response.getBody().getUserId() == "test"
    }

}
