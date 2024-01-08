package pl.zajavka.springrest.infrastructure.petstore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private Long id;
    private String name;
    private String status;
}
