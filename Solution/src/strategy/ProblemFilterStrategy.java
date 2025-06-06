package strategy;

import model.Problem;

import java.util.List;

public interface ProblemFilterStrategy {
    void filter(List<Problem> problems);
}
