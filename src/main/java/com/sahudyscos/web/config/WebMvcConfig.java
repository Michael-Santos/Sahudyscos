
package com.sahudyscos.web.config;

import com.sahudyscos.web.datasource.UserAwareRoutingDatasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
	}
	
	@Primary
	@Bean(name = "dataSource")
	public UserAwareRoutingDatasource dataSource() {
    	return new UserAwareRoutingDatasource();
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/signup").setViewName("signup");
		registry.addViewController("/admin/home").setViewName("admin");
	}

}