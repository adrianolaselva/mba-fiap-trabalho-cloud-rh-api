package br.com.rh.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.rh.controllers"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API's plataforma de RH")
                .description("Documentação API's plataforma de RH").version("1.0")
                .build();
    }

//    @Bean
//    public SecurityConfiguration security() {
//        return new SecurityConfiguration(
//                null, null, null, null,
//                "Bearer access_token",
//                ApiKeyVehicle.HEADER,
//                "Authorization", ",");
//    }


    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(null, null, null, // realm Needed for authenticate button to work
                null, // appName Needed for authenticate button to work
                "  ", // apiKeyValue
                ApiKeyVehicle.HEADER, "Authorization", // apiKeyName
                null);
    }

}
