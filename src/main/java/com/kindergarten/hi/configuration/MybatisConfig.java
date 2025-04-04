package com.kindergarten.hi.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.kindergarten.hi", annotationClass = Mapper.class)
public class MybatisConfig {

}
