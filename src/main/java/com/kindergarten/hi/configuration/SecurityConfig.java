package com.kindergarten.hi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kindergarten.hi.login.model.service.LoginService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private LoginService loginService;

    @Autowired
    public SecurityConfig(LoginService loginService){

        this.loginService = loginService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
    /* 시큐리티 설정을 무시할 정적 리소스들을 등록 (resources 안의 static 폴더 내부의 정적 리소스 유형 무시)*/
    @Override
    public void configure(WebSecurity web){

        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**");
//        web.ignoring().mvcMatchers("/fileupload");
    }

    /* HTTP요청에 대한 권한 설정 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* csrf: 토큰 위주 공격을 막기 위한 작업(default가 'on'인상태)*/
        http.csrf().disable()
                .authorizeRequests()     // 요청에 대한 권한 체크를 어떻게 할 것인지
                .antMatchers("/notice/goregist", "/notice/goupdate", "/notice/godelete").hasRole("AUTH_ADMIN")
                .antMatchers("/student/**").hasAnyRole("AUTH_ADMIN", "AUTH_USER")
                .antMatchers("/lessons/**").hasAnyRole("AUTH_ADMIN", "AUTH_USER")
                .antMatchers("/employee/**").hasAnyRole("AUTH_ADMIN", "AUTH_USER")
                .antMatchers("/goods/**").hasAnyRole("AUTH_ADMIN", "AUTH_USER")
                .antMatchers("/food/**").hasAnyRole("AUTH_ADMIN", "AUTH_EATMANAGE")
                .antMatchers("/payment/**").hasAnyRole("AUTH_ADMIN", "AUTH_USER")
                .antMatchers("/login/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()                    // 로그인 form을 따로 이용해 로그인 처리할것이다.
                .loginPage("/login/gologin")    // login page로 해당 로그인페이지에서 submit요청하는 경로로 지정하겠다는 의미
                .successForwardUrl("/")
                .usernameParameter("empId")
            	.passwordParameter("empPwd")
            .and()
                .logout()                       // 로그아웃 설정
                .logoutRequestMatcher(new AntPathRequestMatcher("/login/logout")) // 로그아웃 시 요청 경로
                .deleteCookies("JSESSIONID")    // 쿠키 제거
                .invalidateHttpSession(true)                          // session정보 무효화
            .and()
                .exceptionHandling()                                  // exception 핸들링 설정
                .accessDeniedPage("/common/denied");
    }

    /* 권한을 등록할 때 인증할 비즈니스 로직이 어떤 것인지 등록*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
    }
}
