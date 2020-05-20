package buur.frederik.timetowork

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
	
	override fun configure(auth: AuthenticationManagerBuilder?) {
		// set config for auth
		auth?.inMemoryAuthentication()
				?.withUser("user")
				?.password("user")
				?.roles("USER")
				?.and()
				?.withUser("admin")
				?.password("admin")
				?.roles("ADMIN")
	}
	
	override fun configure(http: HttpSecurity?) {
		http?.let {
			it.authorizeRequests() // most restrictive to least restrictive
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/user").hasAnyRole("USER", "ADMIN")
					.antMatchers("/").permitAll()
//					.antMatchers("/**").hasRole("ADMIN")
					.and().formLogin()
		}
	}
	
	@Bean
	fun getPasswordEncoder(): PasswordEncoder {
		return NoOpPasswordEncoder.getInstance()
	}
	
}