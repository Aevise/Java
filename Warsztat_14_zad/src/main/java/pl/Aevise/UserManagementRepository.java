package pl.Aevise;

import java.util.List;
import java.util.Optional;

public interface UserManagementRepository {
    Optional<User> findByEmail(String email);

    List<User> findAll();

    List<User> findByName(String name);

    void create(User user);

    void update(String email, User user);

    void delete(String email);
}
