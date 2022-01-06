package beanWood.springBoot.security;

import beanWood.springBoot.filter.CustomAuthenticationFilter;
import beanWood.springBoot.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
		customAuthenticationFilter.setFilterProcessesUrl("/user/login");
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(STATELESS);
		http.authorizeRequests().anyRequest().permitAll();
//		http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN");
//		http.authorizeRequests().antMatchers("/user/login/**", "/user/token/refresh/**").permitAll();
//		http.authorizeRequests().antMatchers("/user/findAll/**").hasAnyAuthority("ROLE_ADMIN");
//		http.authorizeRequests().antMatchers("/user/**").permitAll();
//		http.authorizeRequests().antMatchers("/role/**").permitAll();
//		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
		http.addFilter(customAuthenticationFilter);
		http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
