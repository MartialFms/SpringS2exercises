package fr.fms.login.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity

public class configuration  implements WebMvcConfigurer {
	// configure la secutité

public void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()							// defini les roles
		.antMatchers("/admin").hasRole("ADMIN")			// ajoute les roles
		.antMatchers("/client").hasRole("CLIENT")
		.anyRequest().authenticated()
		.and()
		.formLogin();						// utilise le formulaire d'authentificatio
		// .and().oauth2Login();		>> api externe de login (facebook, google, github, ...

		
	}
	
	// assigne les roles
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		// dans la BDD
		auth.inMemoryAuthentication()
		.withUser("test")
		.password(passwordEncoder().encode("test123"))
		.roles("USER")
		.and()
		.withUser("admin")
		.password(passwordEncoder().encode("admin123"))
		.roles("ADMIN", "USER");
		
		/* dans la memoire
		auth.inMemoryAuthentication()			>> memoire
		auth.jdbcAuthentication()				>> Bdd
		*/
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {		
	   return new BCryptPasswordEncoder();
	}
	
	

}
