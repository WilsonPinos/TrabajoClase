package org.example.trabajoclase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.example.trabajoclase.entity")
@EnableJpaRepositories("org.example.trabajoclase.repository")
public class TrabajoClaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrabajoClaseApplication.class, args);
    }

}
