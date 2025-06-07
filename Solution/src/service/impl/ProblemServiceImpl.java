package service.impl;

import enums.ProblemDifficulty;
import exceptions.ProblemNotFoundException;
import model.Problem;
import repository.ProblemRepository;
import repository.impl.ProblemRepositoryImpl;
import service.ProblemService;
import strategy.ProblemFilterStrategy;
import strategy.ProblemSortStrategy;
import strategy.impl.TagFilterStrategyImpl;

import java.util.List;
import java.util.UUID;

import static constants.ApplicationConstant.IS;
import static constants.ApplicationConstant.MOST_LIKED_PROBLEM_FOR_A_TAG;
import static constants.ApplicationConstant.PROBLEM_NOT_FOUND;
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
    public Problem addProblem(String description, String tagName, ProblemDifficulty problemDifficulty, int score) {
        Problem problem = createProblem(description, tagName, problemDifficulty, score);
        problem.setLikes(score);
        return problemRepository.addProblem(problem);
    }

    private Problem createProblem(String description, String tagName, ProblemDifficulty problemDifficulty, int score) {
        return new Problem(generateId(), description, tagName, problemDifficulty, score);
    }

    @Override
    public void getProblemsSortedByCriteria(ProblemSortStrategy sortStrategy) {
        List<Problem> problems = getAllProblems();
        sortStrategy.sort(problems);
        printProblems(problems);
    }

    @Override
    public void getProblemsFilteredByCriteria(ProblemFilterStrategy filterStrategy) {
        List<Problem> filteredProblems = filterStrategy.filter(getAllProblems());
        printProblems(filteredProblems);
    }

    @Override
    public void getCountOfUsersSolvedProblem(Problem problem) {
        System.out.println(SOLVED_COUNT + problem.getDescription() + IS + problem.getSolvedCount());
    }

    @Override
    public void getMostLikedProblemByTag(ProblemFilterStrategy filterStrategy) {
        List<Problem> problems = filterStrategy.filter(getAllProblems());

        if (problems.isEmpty()) {
            throw new ProblemNotFoundException(PROBLEM_NOT_FOUND);
        }

        int maxLikes = getMaxLikes(problems);

        List<Problem> maxLikedProblems = problems.stream()
                .filter(p -> p.getLikes() == maxLikes)
                .toList();
        if (filterStrategy instanceof TagFilterStrategyImpl tagFilter) {
            System.out.println(MOST_LIKED_PROBLEM_FOR_A_TAG + tagFilter.getTag());
        }
        printProblems(maxLikedProblems);
    }

    private int getMaxLikes(List<Problem> problems) {
        return problems.stream()
                .mapToInt(Problem::getLikes)
                .max()
                .orElse(0);
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
