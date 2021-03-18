package com.sbr.platform.rest.api.interfaces.web.controller.config

import com.sbr.platform.rest.api.domain.service.UserProfileCommandService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import spock.mock.DetachedMockFactory

class MockServiceConfig {

    def factory = new DetachedMockFactory();

    @Bean
    @Primary
    UserProfileCommandService mockUserProfileService() {
        factory.Mock(UserProfileCommandService)
    }
}
