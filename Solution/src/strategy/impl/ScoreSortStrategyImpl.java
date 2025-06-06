package strategy.impl;

import model.Problem;
import strategy.ProblemSortStrategy;

import java.util.List;

public class ScoreSortStrategyImpl implements ProblemSortStrategy {

    @Override
    public void sort(List<Problem> problems) {
        problems.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
    }
}
