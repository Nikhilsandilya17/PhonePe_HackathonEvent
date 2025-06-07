package strategy;

import model.Problem;

import java.util.List;

public interface ProblemFilterStrategy {
    List<Problem> filter(List<Problem> problems);
}
