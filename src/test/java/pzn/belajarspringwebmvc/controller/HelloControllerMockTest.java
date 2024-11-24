package pzn.belajarspringwebmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pzn.belajarspringwebmvc.service.HelloService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//menggunakan mockbean dimana anotation tersebut otomatis meregisterkan menjadi bean
//dan menjadi diutamakan ketimbang setting yang sudah ada.
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    //ketika di tambahkan ini otomatis yang digunakan adalah setup yang disini
    @MockBean
    private HelloService helloService;

    @BeforeEach
    void setUp() {
        Mockito.when(helloService.hello(Mockito.anyString()))
                .thenReturn("Hello World");
    }
    //di atas setting rule untuk keluarin, harusnya kan hello service mengeluarkan
    //sesuai nama. tapi di setting apapun, tetap yang keluar hello world.

    @Test
    void helloName() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name", "fin")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello World"))
        );
    }

    //test for model and view
    @Test
    void helloView() throws Exception {
        mockMvc.perform(
                get("/web/hello").queryParam("name", "fin")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Belajar view")),
                content().string(Matchers.containsString("Hello fin"))
        );
    }
}
