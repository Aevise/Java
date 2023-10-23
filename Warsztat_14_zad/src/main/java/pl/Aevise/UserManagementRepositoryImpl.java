package pl.Aevise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserManagementRepositoryImpl implements UserManagementRepository {

    Map<String, User> USER_MAP = new HashMap<>();
    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(USER_MAP.get(email));
    }

    @Override
    public List<User> findAll() {
        return USER_MAP.values().stream().toList();
    }

    @Override
    public List<User> findByName(String name) {
        return USER_MAP.values().stream()
                .filter(user -> user.getName().equals(name))
                .toList();
    }

    @Override
    public void create(User user){
        USER_MAP.put(user.getEmail(), user);
    }

    @Override
    public void update(String email, User user) {
        USER_MAP.replace(email, user);
    }

    @Override
    public void delete(String email) {
        USER_MAP.remove(email);
    }
}
