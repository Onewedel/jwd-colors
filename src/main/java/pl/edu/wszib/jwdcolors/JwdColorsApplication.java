package pl.edu.wszib.jwdcolors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:db.properties")
public class JwdColorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwdColorsApplication.class, args);
    }

}
