package com.project.auctions.config;

import com.project.auctions.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
    }
    //   http
    //           .authorizeRequests()
    //           .antMatchers("/login*")
    //           .permitAll()
    //           .anyRequest()
    //           .authenticated()
    //           .and()
    //           .httpBasic();

    //  http.cors().and().csrf().disable();
//
/////
    //   http.authorizeRequests()
    //          .antMatchers("/v1/offer").hasAnyRole()
    //           .antMatchers("/v1/offer").hasAnyAuthority()
    //           .anyRequest()
    //           .authenticated()
    //           .and()
    //           .formLogin();
    //      ////    .loginProcessingUrl("/authenticate");
    //   }
//
    ///  @Override
    ///  protected void addViewControllers(ViewControllerRegistry registry){
    ///      registry.addViewController("/").setViewName("home");
    ///      registry.addViewController("/login");
    ///  }


    //  @Override
    //  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //      auth.userDetailsService(userDetailsService);
    //  }


// @Bean
// public CorsConfigurationSource corsConfigurationSource() {
//     CorsConfiguration configuration = new CorsConfiguration();
//     configuration.setAllowedOrigins(Collections.singletonList("*"));
//     configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//     configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
//     configuration.setExposedHeaders(Collections.singletonList("x-auth-token"));
//     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     source.registerCorsConfiguration("/**", configuration);
//     return source;
// }

}
