package Application;

import Application.DataModel.Applicant;
import Application.DataModel.ApplicantRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@SpringBootApplication
@ComponentScan({"Application.Controllers",  "Application.DataModel", "Application.Services"})
@EnableJpaRepositories("Application.DataModel")
@EntityScan("Application/DataModel")
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @Bean(name="entityManagerFactory")
    public EntityManagerFactory getEntityManagerFactoryBean() {
        return Persistence.createEntityManagerFactory("spring-data-jpa-test.odb");
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Bean
    public CommandLineRunner demo(ApplicantRepo repository) {
        return (args) ->  {
            // save a couple of customers

            for (Applicant app : repository.findAll()){
                if(app != null){
                    System.out.println(app.getName() + app.getId());

                    }
                }

            repository.save(new Applicant("Jack", "Bauer"));
            repository.save(new Applicant("Chloe", "O'Brian"));
            repository.save(new Applicant("Kim", "Bauer"));
            repository.save(new Applicant("David", "Palmer"));
            repository.save(new Applicant("Michelle", "Dessler"));
System.out.println();
            // fetch all customers
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (Applicant customer : repository.findAll()) {
                System.out.println(customer.toString());
            }
            System.out.println("");

            // fetch an individual customer by ID
            repository.findById(1)
                    .ifPresent(customer -> {
                        System.out.println("Customer found with findById(1):");
                        System.out.println("--------------------------------");
                        System.out.println(customer.getName());
                        System.out.println("");
                    });

            // fetch customers by last name

            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            System.out.println("");
        };
    }



}