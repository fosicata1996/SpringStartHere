package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "main")
public class ProjectConfig {

    @Bean
    Parrot parrot2() {
        return new Parrot("Miki");
    }

    @Bean("Riki")
    Parrot parrot3() {
        return new Parrot("Riki");
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
