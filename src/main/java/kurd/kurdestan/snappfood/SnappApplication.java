package kurd.kurdestan.snappfood;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SnappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnappApplication.class);
    }
}
