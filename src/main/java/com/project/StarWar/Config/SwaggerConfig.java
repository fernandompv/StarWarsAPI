package com.project.StarWar.Config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty (name="swagger.enable", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket
                .select().apis( RequestHandlerSelectors.any() ).paths( PathSelectors.any() )
                .apis( RequestHandlerSelectors.basePackage( "com.project.starwars.StarWar" ) )
                .build();
        return docket;
    }
}
