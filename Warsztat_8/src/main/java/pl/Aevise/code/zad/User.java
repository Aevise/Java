package pl.Aevise.code.zad;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
@With
public class User implements Comparable<User> {
    String name;
    String surname;
    String email;

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.getName());
    }
}
