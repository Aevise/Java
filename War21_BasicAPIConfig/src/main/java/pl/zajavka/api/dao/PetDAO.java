package pl.zajavka.api.dao;

import pl.zajavka.springrest.infrastructure.petstore.Pet;

import java.util.Optional;

public interface PetDAO {
    Optional<Pet> getPet(final Long petId);
}
