package service;

import enums.ProblemDifficulty;
import model.Problem;
import strategy.ProblemFilterStrategy;
import strategy.ProblemSortStrategy;

public interface ProblemService {
    Problem addProblem(String description, String tagName, ProblemDifficulty problemDifficulty, int score);

    void getProblemsSortedByCriteria(ProblemSortStrategy problemSortStrategy);

    void getProblemsFilteredByCriteria(ProblemFilterStrategy filterStrategy);
    void getCountOfUsersSolvedProblem(Problem problem);

    void getMostLikedProblemByTag(ProblemFilterStrategy filterStrategy);
}
