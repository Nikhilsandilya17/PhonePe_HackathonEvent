package strategy.impl;

import model.Problem;
import strategy.ProblemFilterStrategy;

import java.util.List;

import static constants.ApplicationConstant.FILTERING_BY_TAG;

public class TagFilterStrategyImpl implements ProblemFilterStrategy {

    private final String tag;

    public TagFilterStrategyImpl(String tag) {
        this.tag = tag;
    }

    @Override
    public List<Problem> filter(List<Problem> problems) {
        System.out.println(FILTERING_BY_TAG + tag);
        return problems.stream()
                .filter(p -> p.getTag().equalsIgnoreCase(tag)).toList();
    }

    public String getTag() {
        return tag;
    }
}
