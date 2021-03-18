package com.sbr.platform.rest.api.interfaces.web.controller

import com.sbr.platform.rest.api.domain.service.UserProfileCommandService
import com.sbr.platform.rest.api.interfaces.web.controller.config.MockServiceConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [UserProfileCommandController.class])
@Import([MockServiceConfig])
class UserProfileCommandControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    UserProfileCommandService userProfileService

    def userResponse = Mock(UserResponse)


    def "getUser_returnUserDetails"() {
        given:
        userProfileService.getUserProfileById(*_) >> userResponse
        userResponse.getUserId() >> "test"

        expect:
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("userId").value("test"))
    }
}
