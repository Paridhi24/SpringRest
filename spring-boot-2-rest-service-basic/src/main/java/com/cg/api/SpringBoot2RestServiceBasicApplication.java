package com.cg.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.cg.api.entity.Student;
import com.cg.api.repository.StudentRepository;

@SpringBootApplication
public class SpringBoot2RestServiceBasicApplication {
	

	private static final Logger logger = LoggerFactory.getLogger(SpringBoot2RestServiceBasicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2RestServiceBasicApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner setup(StudentRepository studentRepository) {
		return (args) -> {
			studentRepository.save(new Student( "John", "AER01234"));
			studentRepository.save(new Student( "Pari", "AER01244"));
			studentRepository.save(new Student( "Purnu", "AER01534"));
			studentRepository.save(new Student( "Pavan", "AER01634"));
			logger.info("The sample data has been generated");
		}; 
		*/
	//}
}
