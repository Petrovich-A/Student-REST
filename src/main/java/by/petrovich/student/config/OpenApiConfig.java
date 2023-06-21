package by.petrovich.student.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi publicStudentApi() {
        return GroupedOpenApi.builder()
                .group("Student API")
                .pathsToMatch("/api/v1/students/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(@Value("${application.description}") String appDescription,
                                 @Value("${application.version}") String appVersion,
                                 @Value("${application.title}") String appTitle) {
        return new OpenAPI()
                .info(new Info()
                        .title(appTitle)
                        .version(appVersion)
                        .description(appDescription)
                        .license(new License()
                                .name("GNU general public license")
                                .url("https://github.com/Petrovich-A/Student-REST/blob/master/LICENSE"))
                        .contact(new Contact()
                                .name("Alexandr Petrovich")
                                .email("a.piatrovich@gmail.com")))
                .servers(List.of(new Server()
                        .url("http://localhost:8080")
                        .description("Dev service")));
    }
}
