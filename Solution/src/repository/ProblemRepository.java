package repository;

import model.Problem;

import java.util.List;

public interface ProblemRepository {
    Problem addProblem(Problem problem);
    List<Problem> getAllProblems();
}
