package pzn.belajarspringwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

//tinggal klik run saja disini untuk menjalankan webnya
//buka browser, karena kita menggunakan local host, tinggal ke
// localhost:8181/hello, karena kita belom handle untuk localhost:8181
@SpringBootApplication
public class BelajarSpringWebmvcApplication {

    //make rest template, rest template is use if we want to send/call data
    //from other restful api or server.
    //rest template is not support by spring, so we need build it, but the builder
    //is support by spring to configuration what we need in rest template

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofSeconds(2L))
                .setReadTimeout(Duration.ofSeconds(2L))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringWebmvcApplication.class, args);
    }

}
