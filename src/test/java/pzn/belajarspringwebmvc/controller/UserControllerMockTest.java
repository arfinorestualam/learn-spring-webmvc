package pzn.belajarspringwebmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pzn.belajarspringwebmvc.model.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUser() throws Exception {
        mockMvc.perform(
             get("/user/current")
                     .sessionAttr("user", new User("fin"))
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello fin"))
        );
    }

    //update if user invalid to throw to login page
    @Test
    void getUserNotFound() throws Exception {
        mockMvc.perform(
                get("/user/current")
        ).andExpectAll(
                //is3xx redirection for check is status redirect or not
                status().is3xxRedirection()
        );
    }

}