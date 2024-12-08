package com.NoticiarioAPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.NoticiarioAPI.excecaoGeral.UnAuthorizedUserAuthenticationEntryPoint;
import com.NoticiarioAPI.service.UsuarioService;

@EnableWebSecurity
@Configuration
public class FilterSecurity {
	
	@Autowired
	private UsuarioService uds;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Autowired
	private UnAuthorizedUserAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private SecurityFilterJWT secFilter;
	

	  @Bean
	  AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	      return authenticationConfiguration.getAuthenticationManager();
	  }
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()
		.requestMatchers("noticia/**","/saveUser","/usuario/**").permitAll()
		.requestMatchers("/welcome").authenticated()
//		.requestMatchers("/usuario/{id}","/usuario/id").hasAuthority("ADM")
		.requestMatchers("/mgr").hasAuthority("Manager")
		.requestMatchers("/emp").hasAuthority("Employee")
		.requestMatchers("/hr").hasAuthority("HR")
		.requestMatchers("/common").hasAnyAuthority("Employeee", "Manager", "Admin")
		.anyRequest().authenticated();
		http.addFilterBefore(secFilter, UsernamePasswordAuthenticationFilter.class);
		
//		.and()
//		.formLogin()
//		.defaultSuccessUrl("/usuario/",true)
//		
//		.and()
//		.logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		
//		.and()
//		.exceptionHandling()
//		.accessDeniedPage("/accessDenied")
//		
//		.and()
//		.authenticationProvider(authenticationProvider());
//		
//		return http.build();
		
		
		
	  
		return http.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(uds);
		authenticationProvider.setPasswordEncoder(encoder);;
		return authenticationProvider;
	}

}


