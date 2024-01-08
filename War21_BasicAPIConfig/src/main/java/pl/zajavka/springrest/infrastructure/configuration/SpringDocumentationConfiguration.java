package pl.zajavka.springrest.infrastructure.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.zajavka.SpringRestExampleApplication;

@Configuration
public class SpringDocumentationConfiguration {

    @Bean
    public GroupedOpenApi groupedOpenApi(){
        return GroupedOpenApi.builder()
                .group("default")
                .pathsToMatch("/**")
                .packagesToScan(SpringRestExampleApplication.class.getPackageName())
                .build();
    }

    @Bean
    public OpenAPI springDocOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Employee Application")
                        .contact(contact())
                        .version("1.0"));
    }

    private Contact contact(){
        return new Contact()
                .name("Zajavka")
                .url("https://zajavka.pl")
                .email("hehe@xd.pl");
    }
}
