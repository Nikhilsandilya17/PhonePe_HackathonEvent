package service.impl;

import enums.ProblemStatus;
import model.Problem;
import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import static constants.ApplicationConstant.PROBLEMS_SOLVED_BY_USER;
import static constants.ApplicationConstant.USER_NOT_FOUND;

public class UserServiceImpl implements UserService {

    private static UserService instance;
    private final UserRepository userRepository;
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return  instance;
    }

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public void registerUser(String name, String departmentName, String email) {
        User user = new User(generateId(), name, departmentName, email);
        userRepository.registerUser(user);

    }

    @Override
    public void solveProblem(String id, Problem problem) {
        User user = getUser(id);
        if (user == null) {
            throw new IllegalArgumentException(USER_NOT_FOUND + id);
        }
        problem.setSolvedCount(problem.getSolvedCount() + 1); 
        problem.setProblemStatus(ProblemStatus.SOLVED);
        user.getSolvedProblems().add(problem);
        user.setCurrentScore(user.getCurrentScore() + problem.getScore());
//        getRecommendation(problem.getTag());
    }


    private User getUser(String id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void getProblemsSolvedByUser(String id) {
        User user = getUser(id);
        if (user == null) {
            throw new IllegalArgumentException(USER_NOT_FOUND + id);
        }
        System.out.println(PROBLEMS_SOLVED_BY_USER + user.getName() + ":");
        ProblemServiceImpl.printProblems(user.getSolvedProblems());
    }

    @Override
    public User getCurrentLeaderOfContest() {
        return getAllUsers().stream()
                .max(Comparator.comparingInt(User::getCurrentScore))
                .orElse(null);
    }

    private List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
