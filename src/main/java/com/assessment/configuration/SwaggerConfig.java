package com.assessment.configuration;

import com.assessment.constant.ConstantUtility;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = ConstantUtility.AUTHORIZATION;

    private ApiKey apiKey(){
        return new ApiKey(ConstantUtility.JWT,AUTHORIZATION_HEADER,ConstantUtility.HEADER);
    }

    private List<SecurityContext> securityContexts(){
        return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
    }

    private List<SecurityReference> sf(){
        AuthorizationScope scope = new AuthorizationScope("global","access everything");
        return Arrays.asList(new SecurityReference("JWT",new AuthorizationScope[]{scope}));
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(securityContexts())
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Spring Boot Rest Api")
                .description("Employee Management System")
                .contact(new Contact("Mohd Altaf","https://www.oodlestechnologies.com/", "mohd.altaf@oodles.io"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSES-2.0.html")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
