package com.abhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.context.i18n.LocaleContextHolder;
import java.util.Locale;

@SpringBootApplication
public class MvcProject07InternationalizationI18nApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcProject07InternationalizationI18nApplication.class, args);
    }

    // Define SessionLocaleResolver to resolve locale based on session
    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);  // Set default locale
        return localeResolver;
    }

    // LocaleChangeInterceptor to change locale dynamically via query parameter (e.g., ?lang=en)
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");  // Query parameter to change language
        return interceptor;
    }

	/*@Configuration
	public class WebConfig implements WebMvcConfigurer {
	
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        // Registering the LocaleChangeInterceptor
	        registry.addInterceptor(localeChangeInterceptor());
	    }
	}*/
}
