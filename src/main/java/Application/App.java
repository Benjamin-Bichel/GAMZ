package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;


@SpringBootApplication
@ComponentScan({"Controllers", "Services"})
@EnableJpaRepositories("DataModel")
@EntityScan("DataModel")
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}