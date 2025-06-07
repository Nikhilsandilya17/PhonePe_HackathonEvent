package strategy.impl;

import enums.ProblemDifficulty;
import model.Problem;
import strategy.ProblemFilterStrategy;

import java.util.List;

import static constants.ApplicationConstant.FILTERING_BY_DIFFICULTY;

public class DifficultyFilterStrategyImpl implements ProblemFilterStrategy {

    private final ProblemDifficulty difficulty;

    public DifficultyFilterStrategyImpl(ProblemDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Problem> filter(List<Problem> problems) {
        System.out.println(FILTERING_BY_DIFFICULTY + difficulty);
        return problems.stream()
                .filter(p -> p.getProblemDifficulty() == difficulty)
                .toList();
    }
}
