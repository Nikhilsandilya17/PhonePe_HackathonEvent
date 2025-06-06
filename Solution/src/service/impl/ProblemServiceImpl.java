package service.impl;

import enums.ProblemDifficulty;
import model.Problem;
import repository.ProblemRepository;
import repository.impl.ProblemRepositoryImpl;
import service.ProblemService;
import strategy.ProblemFilterStrategy;
import strategy.ProblemSortStrategy;

import java.util.List;
import java.util.UUID;

import static constants.ApplicationConstant.IS;
import static constants.ApplicationConstant.SOLVED_COUNT;

public class ProblemServiceImpl implements ProblemService {

    private static ProblemServiceImpl instance;
    private final ProblemRepository problemRepository;

    public static synchronized ProblemServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProblemServiceImpl();
        }
        return instance;
    }

    public ProblemServiceImpl() {
        problemRepository = new ProblemRepositoryImpl();
    }

    @Override
    public Problem addProblem(String description, String tag, ProblemDifficulty problemDifficulty, int score) {
        Problem problem = createProblem(description, tag, problemDifficulty, score);
        return problemRepository.addProblem(problem);
    }

    private Problem createProblem(String description, String tag, ProblemDifficulty problemDifficulty, int score) {
        return new Problem(generateId(), description, tag, problemDifficulty, score);
    }

    @Override
    public void getProblemsSortedByCriteria(ProblemSortStrategy sortStrategy) {
        List<Problem> problems = getAllProblems();
        sortStrategy.sort(problems);
        printProblems(problems);
    }

    @Override
    public void getProblemsFilteredByCriteria(ProblemFilterStrategy filterStrategy) {
        List<Problem> problems = getAllProblems();
        filterStrategy.filter(problems);
        printProblems(problems);
    }

    @Override
    public void getCountOfUsersSolvedProblem(Problem problem) {
        System.out.println(SOLVED_COUNT + problem.getDescription() + IS + problem.getSolvedCount());
    }

    private List<Problem> getAllProblems() {
        return problemRepository.getAllProblems();
    }

    public static void printProblems(List<Problem> problems) {
        for (Problem problem : problems) {
            System.out.println(problem.toString());
        }
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
