package com.adminappproject.trajan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.adminappproject.trajan.service.UserService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsServiceBean());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new CORSFilter(), UsernamePasswordAuthenticationFilter.class).httpBasic().and()
				.csrf().ignoringAntMatchers("/login", "/publicApi/**").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
				.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
				.and()
				.authorizeRequests().antMatchers("/login","/publicApi/**").permitAll().anyRequest().fullyAuthenticated()
				.and()
				.logout().clearAuthentication(true)
				.logoutUrl("logout")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
	}


	@Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new CustomUserDetailsService(userService);
    }
}