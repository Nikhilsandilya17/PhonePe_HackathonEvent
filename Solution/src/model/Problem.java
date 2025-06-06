package model;

import enums.ProblemDifficulty;
import enums.ProblemStatus;

public class Problem {
    private String id;
    private String description;
    private String tag;
    private ProblemDifficulty problemDifficulty;
    private int score;
    private ProblemStatus problemStatus;
    private int solvedCount;

    public Problem(String id, String description, String tag, ProblemDifficulty problemDifficulty, int score) {
        this.id = id;
        this.description = description;
        this.tag = tag;
        this.problemDifficulty = problemDifficulty;
        this.score = score;
        problemStatus = ProblemStatus.UNSOLVED;
        solvedCount = 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ProblemDifficulty getProblemDifficulty() {
        return problemDifficulty;
    }

    public void setProblemDifficulty(ProblemDifficulty problemDifficulty) {
        this.problemDifficulty = problemDifficulty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProblemStatus getProblemStatus() {
        return problemStatus;
    }

    public void setProblemStatus(ProblemStatus problemStatus) {
        this.problemStatus = problemStatus;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", problemDifficulty=" + problemDifficulty +
                ", score=" + score +
                ", problemStatus=" + problemStatus +
                '}';
    }

    public int getSolvedCount() {
        return solvedCount;
    }

    public void setSolvedCount(int solvedCount) {
        this.solvedCount = solvedCount;
    }
}
