package training.alif.training.java.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AlifTrainingJavaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlifTrainingJavaSpringBootApplication.class, args);
	}

}
