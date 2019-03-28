package de.exonity01.dataresttest;

import de.exonity01.dataresttest.user.User;
import de.exonity01.dataresttest.user.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			userRepository.save(new User("name1", "surname1"));
			userRepository.save(new User("name2", "surname2"));
			userRepository.save(new User("name3", "surname3"));
		};
	}
}
