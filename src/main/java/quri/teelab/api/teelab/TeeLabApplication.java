package quri.teelab.api.teelab;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "quri.teelab.api")
@EnableJpaAuditing
public class TeeLabApplication {

    public static void main(String[] args) {
        // Load environment variables from .env in project root before starting Spring Boot
        try {
            io.github.cdimascio.dotenv.Dotenv dotenv = io.github.cdimascio.dotenv.Dotenv.configure()
                .directory(".")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
            dotenv.entries().forEach(entry -> {
                if (System.getenv(entry.getKey()) == null) {
                    System.setProperty(entry.getKey(), entry.getValue());
                }
            });
        } catch (Exception e) {
            System.err.println("Could not load .env file: " + e.getMessage());
        }
        SpringApplication.run(TeeLabApplication.class, args);
        System.out.println("\n----------------------------------------------------------");
        System.out.println("Swagger UI available at: http://localhost:8080/swagger-ui/index.html");
        System.out.println("----------------------------------------------------------\n");
    }

}
