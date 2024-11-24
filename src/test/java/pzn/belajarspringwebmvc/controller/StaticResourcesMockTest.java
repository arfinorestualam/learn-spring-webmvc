package pzn.belajarspringwebmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class StaticResourcesMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStaticResources() throws Exception {
        mockMvc.perform(
                //get will be search first at controller,
                //if there is no controller, will search in resources static
                //and if no static found will be throw 404
                get("/index.html")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Static"))
        );
    }
}
