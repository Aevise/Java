package pl.zajavka.springrest.infrastructure.petstore;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zajavka.api.dao.PetDAO;
import pl.zajavka.infrastructure.petstore.api.PetApi;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PetClientImpl implements PetDAO {

    private final PetApi petApi;
    private final PetMapper petMapper;

    @Override
    public Optional<Pet> getPet(Long petId) {
        try{
            final var available = petApi.findPetsByStatusWithHttpInfo("available").block()
                    .getBody();
            return Optional.ofNullable(petApi.getPetById(petId).block())
                    .map(petMapper::map);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
