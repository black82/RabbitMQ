package com.ecabs.swagger;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    Contact contact = new Contact(
            "Railean Iurie",
            "https://www.linkedin.com/in/iurie-railean-503a65170/",
            "blackrailean@gmail.com"
    );
    List<VendorExtension> vendorExtensions = new ArrayList<>();

    ApiInfo apiInfo = new ApiInfo(
            "Booking app REST Web Service documentation",
            "This Service Receives Booking and produces a message via RabbitMq at another processing service.\n ", "1.0",
            "none", contact,
            "none", "none", vendorExtensions);


    @Bean
    public Docket swaggerSpringfoxDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
                .genericModelSubstitutes(ResponseEntity.class).forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalDateTime.class, Date.class)
                .directModelSubstitute(ZonedDateTime.class, Date.class).select()
                .paths(PathSelectors.any()).build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
