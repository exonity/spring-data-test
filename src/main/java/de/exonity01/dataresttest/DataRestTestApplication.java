package de.exonity01.dataresttest;

import de.exonity01.dataresttest.user.User;
import de.exonity01.dataresttest.user.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DataRestTestApplication {

	private UserRepository userRepository;

	public DataRestTestApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataRestTestApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			userRepository.save(new User("a", "a", LocalDate.now()));
			userRepository.save(new User("a", "b", LocalDate.now()));
			userRepository.save(new User("a", "c", LocalDate.now()));
			userRepository.save(new User("b", "b", LocalDate.now()));
			userRepository.save(new User("c", "c", LocalDate.now()));
		};
	}
}
