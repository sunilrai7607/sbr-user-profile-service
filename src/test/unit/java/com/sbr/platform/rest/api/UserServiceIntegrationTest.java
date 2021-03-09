package com.sbr.platform.rest.api;

import com.sbr.platform.rest.api.model.response.UserResponse;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * Method to get the user details by userId
     */
    public void getUser_returnUserDetails() {
        //arrange

        //action
        ResponseEntity<UserResponse> response = testRestTemplate.getForEntity("/users/test", UserResponse.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getUserId()).isEqualTo("test");
    }

}
