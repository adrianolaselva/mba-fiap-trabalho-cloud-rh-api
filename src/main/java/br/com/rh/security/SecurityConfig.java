package br.com.rh.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Value(value = "${auth0.apiAudience}")
//    private String apiAudience;
//    @Value(value = "${auth0.issuer}")
//    private String issuer;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        JwtWebSecurityConfigurer
//                .forRS256(apiAudience, issuer)
//                .configure(http)
//                .cors().and().csrf().disable().authorizeRequests()
//                .anyRequest().permitAll();
//    }
}