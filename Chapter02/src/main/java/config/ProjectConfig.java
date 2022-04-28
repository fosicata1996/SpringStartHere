package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    @Primary
    Parrot parrot() {
        return new Parrot("Koko");
    }

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
