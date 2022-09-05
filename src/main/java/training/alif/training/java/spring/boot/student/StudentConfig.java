package training.alif.training.java.spring.boot.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student alif = new Student(
                    "alif",
                    LocalDate.of(1996, Month.AUGUST, 13),
                    "alif@example.com");

            Student abu = new Student(
                    "abu",
                    LocalDate.of(2000, Month.JANUARY, 1),
                    "test@example.com");

            repository.saveAll(List.of(alif, abu));
        };
    }
}
