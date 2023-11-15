package ma.youcode.demosaasplatform;

import ma.youcode.demosaasplatform.domain.User;
import ma.youcode.demosaasplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class DemoSaasPlatformApplication {

	@Autowired
	UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoSaasPlatformApplication.class, args);
	}



	//@Bean
	CommandLineRunner runner(){
		return args -> {
			userRepository.save(User.builder().id(1).name("Mounir").build());
			userRepository.save(User.builder().id(2).name("Alex").build());
		};
	}
}
