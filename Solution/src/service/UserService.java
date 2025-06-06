package service;

import model.Problem;
import model.User;

public interface UserService {
    void registerUser(String name, String departmentName, String email);

    void solveProblem(String s, Problem problem);

    void getProblemsSolvedByUser(String id);

    User getCurrentLeaderOfContest();
}
