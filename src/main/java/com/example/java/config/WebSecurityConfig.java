package com.example.java.config;


import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;
//	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	
	@Bean
	public DataSource getDataSource() throws NamingException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/trainingdb?useSSL=false&allowPublicKeyRetrieval=true");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		return dataSource;
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		.dataSource(getDataSource())
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from users where username=?");
	}
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/homePage").access("hasRole('ROLE_USER')")
//		.antMatchers("/user/**").permitAll()
//		
//		.and()
//		.formLogin().loginPage("/login.html")
//		.loginProcessingUrl("/loginPage")
//		.usernameParameter("username").passwordParameter("password")
//				.defaultSuccessUrl("/homePage")
//				.failureUrl("/loginPage?error")
//				
//				.and().logout()
//				.logoutSuccessUrl("/loginPage?logout")
//				.and().csrf().disable();
		
		http.csrf().disable();
		http.authorizeRequests()
		
		.antMatchers("/welcome", "/home","/").permitAll()
		
		.antMatchers("/user/**").access("hasRole('ROLE_USER')")
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.and()
		.formLogin().loginPage("/dang-nhap").loginProcessingUrl("/login")
			.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/user")
			.failureUrl("/dang-nhap?error=failed")
				.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/dang-nhap")
				.and()
					.exceptionHandling().accessDeniedPage("/dang-nhap?error=deny");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	
	
	

}
