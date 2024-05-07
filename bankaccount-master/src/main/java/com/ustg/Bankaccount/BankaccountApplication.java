package com.ustg.Bankaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import com.ustg.Bankaccount.filter.accountfilter;
@SpringBootApplication
public class BankaccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankaccountApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean getfileterbean()
	{
	UrlBasedCorsConfigurationSource urlconfig=new UrlBasedCorsConfigurationSource();	
	CorsConfiguration config=new CorsConfiguration();
	config.setAllowCredentials(true);
	config.setAllowedHeaders(Arrays.asList("Accept","Authorization"));
	config.addAllowedOrigin("*");
	config.addAllowedMethod("*");
	config.addAllowedHeader("*");
	urlconfig.registerCorsConfiguration("/**", config);
	FilterRegistrationBean fbean=new FilterRegistrationBean(new CorsFilter(urlconfig));
	fbean.setFilter(new accountfilter());
	fbean.addUrlPatterns("/api/account/*");
	return fbean;
	}

}
