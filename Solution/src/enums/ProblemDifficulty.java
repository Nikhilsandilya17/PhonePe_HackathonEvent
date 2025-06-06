package enums;

public enum ProblemDifficulty {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private final int level;

    ProblemDifficulty(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
