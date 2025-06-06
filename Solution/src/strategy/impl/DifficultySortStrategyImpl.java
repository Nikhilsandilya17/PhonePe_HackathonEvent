package strategy.impl;

import model.Problem;
import strategy.ProblemSortStrategy;

import java.util.Comparator;
import java.util.List;

public class DifficultySortStrategyImpl implements ProblemSortStrategy {

    @Override
    public void sort(List<Problem> problems) {
        problems.sort(Comparator.comparingInt(p -> p.getProblemDifficulty().getLevel()));
    }
}
