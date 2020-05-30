package buur.frederik.timetowork

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.sql.DataSource

@EnableWebSecurity
class SecurityConfig(
		@Autowired val dataSource: DataSource
) : WebSecurityConfigurerAdapter() {
	
	override fun configure(auth: AuthenticationManagerBuilder?) {
		// set config for auth
//		auth?.inMemoryAuthentication()
//				?.withUser("user")
//				?.password("user")
//				?.roles("USER")
//				?.and()
//				?.withUser("admin")
//				?.password("admin")
//				?.roles("ADMIN")
		
		auth?.jdbcAuthentication()
				?.dataSource(dataSource)
				?.usersByUsernameQuery("select username,password,enables from users where username = ?") // here you can override how users from db should be queried
				?.usersByUsernameQuery("select username,authorities from authorities where username = ?") // here you can override how authorities from db should be queried
	}
	
	override fun configure(http: HttpSecurity?) {
		http?.authorizeRequests()
				?.antMatchers("/admin")?.hasRole("ADMIN")
				?.antMatchers("/user")?.hasAnyRole("USER", "ADMIN")
				?.antMatchers("/")?.permitAll()
				?.and()?.formLogin()
	}
	
	@Bean
	fun getPasswordEncoder(): PasswordEncoder {
		return NoOpPasswordEncoder.getInstance()
	}
	
}