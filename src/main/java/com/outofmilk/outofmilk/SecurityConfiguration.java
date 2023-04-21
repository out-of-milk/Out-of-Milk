package com.outofmilk.outofmilk;

import com.outofmilk.outofmilk.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true) // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page

                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/login") // append a query string value

                /* Pages that require authentication */
                .and()
                .authorizeHttpRequests()
                .requestMatchers(

                        "/users/profile", // only authenticated users can create posts
                        "/user", // only authenticated users can view user profile
                        "/user/{id}/uc", // only authenticated users can view user profile
                        "/user/dpl", // only authenticated users can remove ingredients list
                        "/user/dgl", // only authenticated users can remove ingredients list
                        "/user/egl", // only authenticated users can email ingredients list
                        "/user/{id}/dpi", // only authenticated users can remove ingredients
                        "/user/{id}/dgi", // only authenticated users can remove ingredients
                        "/user/{id}/dhr", // only authenticated users can remove hidden recipes
                        "/user/{id}/afr", // only authenticated users can add favorite recipes
                        "/user/{id}/ahr", // only authenticated users can add hidden recipes
                        "/recipe/{id}/ari", // only authenticated users can add recipes ingredients to grocery list
                        "/recipe/{id}", // only authenticated users can view recipe details
                        "/user/addItemPantry", // only authenticated users can add ingredients
                        "/user/addItemGrocery" // only authenticated users can add ingredients
                )
                .authenticated()

                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/", "/recipe", "/login", "/sign-up", "/css/**", "/img/**", "/js/**","/AboutUs") // anyone can see the home and the posts pages
                .permitAll()
        ;
        return http.build();
    }

}

