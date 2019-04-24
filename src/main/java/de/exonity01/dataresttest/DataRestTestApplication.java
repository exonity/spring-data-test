package de.exonity01.dataresttest;

import de.exonity01.dataresttest.test.TestServiceA;
import de.exonity01.dataresttest.user.User;
import de.exonity01.dataresttest.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DataRestTestApplication {

    private UserRepository userRepository;

    private TestServiceA testServiceA;

    public DataRestTestApplication(UserRepository userRepository, TestServiceA testServiceA) {
        this.userRepository = userRepository;
        this.testServiceA = testServiceA;
    }

    public static void main(String[] args) {
        SpringApplication.run(DataRestTestApplication.class, args);
    }

    @EventListener({ContextRefreshedEvent.class})
    void sendDatabase() {
        userRepository.save(new User("a", "a"));
        userRepository.save(new User("a", "b"));
        userRepository.save(new User("a", "c"));
        userRepository.save(new User("b", "b"));
        userRepository.save(new User("c", "c"));

        // testServiceA.send();
    }
}
