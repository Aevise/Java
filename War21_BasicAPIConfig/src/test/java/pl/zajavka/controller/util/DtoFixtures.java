package pl.zajavka.controller.util;

import lombok.experimental.UtilityClass;
import pl.zajavka.api.dto.EmployeeDTO;
import pl.zajavka.api.dto.PetDTO;
import pl.zajavka.springrest.infrastructure.database.entity.EmployeeEntity;

import java.math.BigDecimal;

@UtilityClass
public class DtoFixtures {
    public static EmployeeDTO someEmployee1() {

        return EmployeeDTO.builder()
                .employeeId(10)
                .name("name")
                .surname("surname")
                .salary(new BigDecimal(1000))
                .phone("+48 654 535 534")
                .email("hehe@xd.pl")
                .build();
    }

    public static PetDTO somePet(){
        return PetDTO.builder()
                .petId(1)
                .petStorePetId(4L)
                .name("lion")
                .category("dogs")
                .build();
    }
}
