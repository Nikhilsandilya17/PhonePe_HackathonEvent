package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    void registerUser(User user);

    User getUserById(String id);

    List<User> getAllUsers();
}
