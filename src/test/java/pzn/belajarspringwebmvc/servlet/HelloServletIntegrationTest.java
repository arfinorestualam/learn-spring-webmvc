package pzn.belajarspringwebmvc.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

//cause it is not controller, it can't use mockmvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloServletIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void helloServlet() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/servlet/hello", String.class);
        assert response != null;
        Assertions.assertEquals("Hello from servlet", response.trim());
    }

}