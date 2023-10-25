package com.example.springBootExercise;

import com.example.springBootExercise.model.AppUser;
import com.example.springBootExercise.model.AppUserRole;
import com.example.springBootExercise.repository.AppRoleRepository;
import com.example.springBootExercise.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExerciseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AppRoleRepository roleRepository, AppUserRepository userRepository, PasswordEncoder passwordEncoder)
	{
		return args -> {
			AppUserRole role1 = new AppUserRole(null, "ROLE_USER");
			AppUserRole role2 = new AppUserRole(null, "ROLE_ADMIN");
			AppUser user1 = new AppUser(null, "jnr", "joe","joe1", passwordEncoder.encode("1234"),role1);
			AppUser user2 = new AppUser(null, "john", "doe","doe1", passwordEncoder.encode("12345"),role2);

			userRepository.save(user1);
			roleRepository.save(role1);
			userRepository.save(user2);
			roleRepository.save(role2);


		};
	}

}
