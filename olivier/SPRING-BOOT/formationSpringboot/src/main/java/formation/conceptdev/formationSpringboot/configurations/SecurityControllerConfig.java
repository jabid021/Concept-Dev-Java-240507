package formation.conceptdev.formationSpringboot.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

//@Configuration
public class SecurityControllerConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// bean SecurityFilterChain
	// definition les url à traiter et les regles de traitements
	// on definie toujours une regle qui bloque
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off

		http.csrf(csrf -> csrf.disable());

		http.authorizeHttpRequests(req -> {
			// req.requestMatchers("/public/**").permitAll();
			// req.anyRequest().authenticated();

			req.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/inscription/**").anonymous()
				.requestMatchers("/public/**").permitAll()
				.anyRequest().hasAnyRole("ADMIN");
		});

		http.formLogin(Customizer.withDefaults());

		return http.build();
		// @formatter:on
	}

	// definition des utilisateurs
	// pour spring 1 utilisateur=>UserDetails
	// UserDetailsService => loadUserByUsername(String username)

	// UserDetails en memoire
//	@Bean
//	UserDetailsService inMemory() {
//		// @formatter:off
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("olivier")
//								.password("{noop}olivier")
//								.roles("ADMIN")
//								.build());
//		manager.createUser(User.withUsername("toto")
//				.password("{noop}toto")
//				.roles("USER")
//				.build());
//
//		return manager;
//		// @formatter:on
//	}

}
