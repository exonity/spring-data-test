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
			userRepository.save(new User("a", "a"));
			userRepository.save(new User("a", "b"));
			userRepository.save(new User("a", "c"));
			userRepository.save(new User("b", "b"));
			userRepository.save(new User("c", "c"));
		};
	}
}
