package quri.teelab.api.teelab;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeeLabApplication {

    public static void main(String[] args) {
        // Cargar variables de entorno desde .env antes de iniciar Spring Boot
        try {
            io.github.cdimascio.dotenv.Dotenv dotenv = io.github.cdimascio.dotenv.Dotenv.configure()
                .directory("src/main/resources")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
            dotenv.entries().forEach(entry -> {
                if (System.getenv(entry.getKey()) == null) {
                    System.setProperty(entry.getKey(), entry.getValue());
                }
            });
        } catch (Exception e) {
            System.err.println("No se pudo cargar el archivo .env: " + e.getMessage());
        }
        SpringApplication.run(TeeLabApplication.class, args);
    }

}
