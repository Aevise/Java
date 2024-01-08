package pl.zajavka.springrest.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.springrest.infrastructure.database.entity.PetEntity;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Integer> {
}
