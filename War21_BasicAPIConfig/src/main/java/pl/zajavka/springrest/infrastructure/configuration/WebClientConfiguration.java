package pl.zajavka.springrest.infrastructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zajavka.infrastructure.petstore.ApiClient;
import pl.zajavka.infrastructure.petstore.api.PetApi;

@Configuration
public class WebClientConfiguration {

    @Value("${api.petStore.url}")
    private String getPetStoreUrl;
    public static final String PET_STORE_URL = "https://petstore3.swagger.io/api/v3";

    @Bean
    public ApiClient petStoreApiClient(final ObjectMapper objectMapper) {
        final var exchangeStrategies = ExchangeStrategies
                .builder()
                .codecs(configurer -> {
                    configurer
                            .defaultCodecs()
                            .jackson2JsonEncoder(
                                    new Jackson2JsonEncoder(
                                            objectMapper,
                                            MediaType.APPLICATION_JSON
                                    )
                            );
                    configurer
                            .defaultCodecs()
                            .jackson2JsonDecoder(
                                    new Jackson2JsonDecoder(
                                            objectMapper,
                                            MediaType.APPLICATION_JSON
                                    )
                            );
                })
                .build();

        final var webClient =  WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .build();

        ApiClient apiClient = new ApiClient(webClient);
        apiClient.setBasePath(getPetStoreUrl);
        return apiClient;
    }

    @Bean
    public PetApi petApi(final ObjectMapper objectMapper){
        return new PetApi(petStoreApiClient(objectMapper));
    }
}
