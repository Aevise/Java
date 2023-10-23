package pl.Aevise;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@With
@Builder
public class User implements Comparable<User> {
    String name;
    String surname;
    String email;

    @Override
    public int compareTo(User user) {
        int comparisonResult = this.name.compareTo(user.name);
        if (comparisonResult == 0) {
            comparisonResult = this.surname.compareTo(user.surname);
            if (comparisonResult == 0) {
                return this.email.compareTo(user.email);
            }
            return comparisonResult;
        }
        return comparisonResult;
    }
}
