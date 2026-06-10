package org.portfolio.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LoginAndLogoutConfigurator {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
                        authorizeRequests -> authorizeRequests
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers( "/reg", "/login").anonymous()
                                .anyRequest().permitAll())
                .formLogin(formLogin ->
                        formLogin.loginPage("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/", true)
                                .failureHandler((request, response, exception) -> {
                                    if (exception instanceof LockedException) {
                                        response.sendRedirect("/login?banned");
                                    } else {
                                        response.sendRedirect("/login?error");
                                    }
                                }))
                .logout(formLogout->
                        formLogout.logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                                .invalidateHttpSession(true));

        return httpSecurity.build();
    }
}
