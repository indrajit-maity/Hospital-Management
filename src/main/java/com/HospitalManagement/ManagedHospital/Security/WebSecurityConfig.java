package com.HospitalManagement.ManagedHospital.Security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private  final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrfConfig-> csrfConfig.disable())
                .sessionManagement(sessionConfig->sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth-> auth
                                .requestMatchers("/patient/**").permitAll()
                        .requestMatchers("/auth/sign-up","/auth/log-in").permitAll()
//                        .requestMatchers("/admin/**").authenticated()
//                        .requestMatchers("/admin/patients").hasRole("Admin")
//                        .requestMatchers("/admin/**").hasAnyRole("Doctor","Admin")
                                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }


//    @Bean
//    UserDetailsService userDetailsService(){
//        UserDetails user1 =User.withUsername("admin")
//                .password(passwordEncoder.encode("pass"))
//                .roles("Admin")
//                .build();
//

//        UserDetails user2=User.withUsername("patient")
//                .password(passwordEncoder.encode("pass"))
//                .roles("Patient")
//                .build();
//
//
//
//        return new void InMemoryUserDetailsManager(user1, user2);
//    }

}
