package pl.Aevise.code.zad;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserManagementService {
    private Map<String, User> usersMap = new LinkedHashMap<>();

    public void create(User user) {
        String userEmail = user.getEmail();
        if (usersMap.containsKey(userEmail)) {
            throw new RuntimeException(String.format("User with email [%s] is already created", userEmail));
        } else {
            usersMap.put(userEmail, user);
        }
    }

    public Optional<User> findByEmail(String email) throws RuntimeException {
        if (!usersMap.containsKey(email)) {
            return Optional.empty();
        }
        return Optional.of(usersMap.get(email));
    }

    public Map<String, User> findAll() {
        return usersMap;
    }

    public List<User> findByName(String name) {
        return usersMap.values()
                .stream()
                .filter(user -> user.getName().equals(name))
                .toList();
    }

    public void update(String email, User user) throws RuntimeException {
        this.delete(email);
        usersMap.put(user.getEmail(), user);
    }

    public void delete(String email) {
        if (!usersMap.containsKey(email)) {
            throw new RuntimeException(String.format("User with email: [%s] doesn't exist", email));
        }
        usersMap.remove(email);
    }
}
