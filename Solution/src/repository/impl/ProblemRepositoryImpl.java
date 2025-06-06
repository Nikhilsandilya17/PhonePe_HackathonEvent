package repository.impl;

import model.Problem;
import repository.ProblemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemRepositoryImpl implements ProblemRepository {

    private final Map<String, Problem> questionLibrary;

    public ProblemRepositoryImpl() {
        questionLibrary = new HashMap<>();
    }

    @Override
    public Problem addProblem(Problem problem) {
        System.out.println("Saving problem to the database: " + problem);
        questionLibrary.put(problem.getId(), problem);
        return problem;
    }

    @Override
    public List<Problem> getAllProblems() {
        return new ArrayList<>(questionLibrary.values());
    }
}
