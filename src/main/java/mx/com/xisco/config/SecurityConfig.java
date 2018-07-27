
package mx.com.xisco.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
            http
                .authorizeRequests()
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .antMatchers("/webjars/**").permitAll()
                    .antMatchers("/index").permitAll()
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers("/login*","/signUp*").permitAll()
                    .antMatchers("/invalidSession*").anonymous()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home.html")
                    .failureUrl("/login?error=true")
                    .failureHandler(authenticationFailureHandler)
                .permitAll()
                    .and()
                .sessionManagement()
                    .invalidSessionUrl("/")
                    .sessionFixation().none()
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .permitAll();
        // @formatter:on
    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
    // @formatter:off
		auth.inMemoryAuthentication()
			.withUser(User.withDefaultPasswordEncoder()
			.username("user").password("password").roles("USER"));
	// @formatter:on
    }

}
