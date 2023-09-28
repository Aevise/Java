package pl.Aevise.code.zad;

import lombok.*;

@Builder
@Data
@With
public class User {
    private String name;
    private String surname;
    private String email;
}
