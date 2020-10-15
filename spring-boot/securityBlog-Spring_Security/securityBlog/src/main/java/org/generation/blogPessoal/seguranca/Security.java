package org.generation.blogPessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	//cria os privilégios
	@Override // sobescreve o método dentro da classe WebSecurityConfigurerAdapter(configure)
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.POST, "/").permitAll()
		
		.antMatchers(HttpMethod.GET, "/cadastrarTema").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/cadastrarTema").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/formTema").permitAll()
		.antMatchers(HttpMethod.POST, "/formTema").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	/*@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	@Override //cria acessos controlados / construção de gestão de autetificação que libera quem vai ter acesso, com um usuário e senha
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("lu").password("lu").roles("administrador");

	}

	 * @Override protected void configure(HttpSecurity http) throws Exception{
	 * http.authorizeRequests().antMatchers(HttpMethod.POST,
	 * "/tema").permitAll().antMatchers(HttpMethod.POST,
	 * "/postagens").permitAll().antMatchers(HttpMethod.GET,
	 * "/tema").permitAll().anyRequest().authenticated().and().formLogin().permitAll
	 * ();
	 * 
	 * }
	 */
}
