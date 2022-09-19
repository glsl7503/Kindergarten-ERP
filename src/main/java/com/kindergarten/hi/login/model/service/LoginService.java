package com.kindergarten.hi.login.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/* 스프링 시큐리티가 제공하는 UserDetailsService를 상속받아야한다. */
public interface LoginService extends UserDetailsService {
}
