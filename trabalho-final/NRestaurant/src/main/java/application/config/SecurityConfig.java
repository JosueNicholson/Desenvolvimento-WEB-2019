package application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import application.security.UserDetailsServiceImplementation;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImplementation userDetailsServiceImplementation;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/prato/galeria").permitAll()
		.antMatchers("/carrinho/visualizarCarrinho").permitAll()
		.antMatchers("/carrinho/adicionarItemForm/**").permitAll()
		.antMatchers("/carrinho/adicionarItem").permitAll()
		.antMatchers("/carrinho/removerItem/**").permitAll()
		.antMatchers("/cliente/salvar").permitAll()
		.antMatchers("/cliente/form").permitAll()
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/cliente/logar").defaultSuccessUrl("/prato/galeria").permitAll()
		.permitAll()
		
		.and()
		.logout()
		.logoutRequestMatcher(new  AntPathRequestMatcher("/cliente/logout"))
		.logoutSuccessUrl("/cliente/logar?logout")
		
		;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImplementation).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/img/**", "/js/**", "/images/**");
	}

}
