package com.sbr.platform.rest.api.controller

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = [UserController.class])
class UserControllerSpec extends Specification{

    @Autowired
    MockMvc mockMvc

    def "getUser_returnUserDetails"() {

        when:
        def response = mockMvc.perform(get("/api/v1/users/test"))

        then:
        response.andExpect(status().isOk())
    }
}
