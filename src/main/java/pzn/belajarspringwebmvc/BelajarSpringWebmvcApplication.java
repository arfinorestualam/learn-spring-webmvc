package pzn.belajarspringwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//tinggal klik run saja disini untuk menjalankan webnya
//buka browser, karena kita menggunakan local host, tinggal ke
// localhost:8181/hello, karena kita belom handle untuk localhost:8181
@SpringBootApplication
public class BelajarSpringWebmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringWebmvcApplication.class, args);
    }

}
