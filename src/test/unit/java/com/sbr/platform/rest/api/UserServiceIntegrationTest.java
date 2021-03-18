package com.sbr.platform.rest.api;

import com.sbr.platform.rest.api.interfaces.web.model.UserResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * Method to get the user details by userId
     */
    @Test
    public void getUser_returnUserDetails() {
        //arrange

        //action
        ResponseEntity<UserResponse> response = testRestTemplate.getForEntity("/api/v1/users/test", UserResponse.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getUserId()).isEqualTo("test");
    }

}
