package com.sprint3r.deans4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDataJpaApplication {

    @Bean
    public InitializingBean seedDatabase(ProductRepository repository) {
        return () -> {
            repository.save(new Product("Intel i7", "CPU", "https://i.ytimg.com/vi/mmHY8Kj4vCk/maxresdefault.jpg", "i7 7700k", 7000));
            repository.save(new Product("AMD Raizen 1700X", "CPU", "http://cdn.wccftech.com/wp-content/uploads/2017/02/AMD-Ryzen-CPU.png", "AMD 1700X", 3500));
            repository.save(new Product("Galax HOF GTX1080", "GPU", "https://www.custompcreview.com/wp-content/uploads/2016/05/29140448720l.jpg", "GTX 1080", 2350));
            repository.save(new Product("Raiden Plasma", "RAM", "https://i.ytimg.com/vi/SApyTXm_jQE/maxresdefault.jpg", "DDR4 32GB", 8872));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataJpaApplication.class, args);
    }
}
