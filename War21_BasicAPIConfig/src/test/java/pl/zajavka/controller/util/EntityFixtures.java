package pl.zajavka.controller.util;

import jakarta.persistence.Column;
import pl.zajavka.api.dto.PetDTO;
import pl.zajavka.springrest.infrastructure.database.entity.EmployeeEntity;

import java.math.BigDecimal;

public class EntityFixtures {
    public static EmployeeEntity someEmployee1() {

        return EmployeeEntity.builder()
                .employeeId(10)
                .name("name")
                .surname("surname")
                .salary(new BigDecimal(1000))
                .phone("+48 654 535 534")
                .email("hehe@xd.pl")
                .build();
    }


}
