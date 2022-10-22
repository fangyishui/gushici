package org.gushi.gushici;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.gushi.gushici.mapper")
public class GushiciApplication {

    public static void main(String[] args) {
        SpringApplication.run(GushiciApplication.class, args);
    }

}
