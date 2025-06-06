package repository.impl;

import model.User;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> userDatabase;

    public UserRepositoryImpl() {
        userDatabase = new HashMap<>();
    }

    @Override
    public void registerUser(User user) {
        System.out.println("Saving User: "+ user.getName());
        userDatabase.put(user.getEmail(), user);
    }

    @Override
    public User getUserById(String id) {
        return userDatabase.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase.values());
    }
}
