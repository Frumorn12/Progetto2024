package it.unical.informatica.progettobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication

@ServletComponentScan
public class ProgettoBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgettoBackEndApplication.class, args);
    }

}
