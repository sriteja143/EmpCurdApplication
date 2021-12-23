package com.guru.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {                                    
	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
	 * .build(); }
	 */
    
    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("person-api-1.0")
            .select()
            //.apis(RequestHandlerSelectors.basePackage("com.guru.controller"))
           // .paths(PathSelectors.regex("/test/*"))
            .apis(RequestHandlerSelectors.basePackage("com.guru.controller"))
           // .paths(PathSelectors.ant("/test/**"))
          //  .paths(PathSelectors.regex("[t][e][s][t][/][a-zA-Z0-9]*"))
            .paths(PathSelectors.regex("[emp/]*"))
            .build()
            .apiInfo(new ApiInfoBuilder().version("1.0").title("Person API").description("Documentation Person API v1.0").build());
    }
    
    @Bean
    public Docket swaggerPersonApi20() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("person-api-2.0")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.guru.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(new ApiInfoBuilder().version("1.1").title("Person API 2").description("Documentation Person API v1.2").build());
    }
}