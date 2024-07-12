package formation.conceptdev.exoBoot.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(auth->{
			auth.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()  
				.requestMatchers("/public/**").permitAll()
				.requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
				.anyRequest().hasAnyRole("ADMIN");
		});
		
		http.formLogin(Customizer.withDefaults());
		return http.build();
	}
	

}
