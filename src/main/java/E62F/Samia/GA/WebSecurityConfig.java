/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2022-Jan-10 10:02:59 
 * 
 */

package E62F.Samia.GA;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 20008933
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean

	public MemberDetailsService memberDetailsService() {

		return new MemberDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(memberDetailsService());

		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/categories/add", "/categories/edit/*", "/categories/save", "/categories/delete/*",
						"/books/add", "/books/edit/*", "/books/save", "/books/delete/*", "/members", "/members/edit/*",
						"/members/save", "/members/delete/*")
				.hasRole("ADMIN")

				.antMatchers("/").permitAll().antMatchers("/categories").permitAll().antMatchers("/books").permitAll()
				.antMatchers("/members/add").permitAll().antMatchers("/bootstrap/*/*").permitAll()
				.antMatchers("/images/*").permitAll().antMatchers("/bks/*").permitAll().antMatchers("/books/*")
				.permitAll().antMatchers("/uploads/books/*/*").permitAll().antMatchers("/books/category/*").permitAll()

				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
				.logoutUrl("/logout").permitAll().and().exceptionHandling().accessDeniedPage("/403");

	}
}