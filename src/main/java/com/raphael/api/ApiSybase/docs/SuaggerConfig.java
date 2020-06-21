package com.raphael.api.ApiSybase.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SuaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.raphael.api.ApiSybase"))
                .paths(PathSelectors.regex("/api/v1.*"))
                .build()
                .apiInfo(metaDados());
    }

    private ApiInfo metaDados() {

        return new ApiInfoBuilder()
                .title("Api Sybase by RB")
                .description("Dados Sybase 9 - Base Tributos")
                .version("1.0")
                .contact(new Contact("Raphael Brangioni", "http://teste.com.br", "raphaelbrangioni@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
