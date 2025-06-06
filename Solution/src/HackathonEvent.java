import enums.ProblemDifficulty;
import model.Problem;
import model.User;
import service.ProblemService;
import service.UserService;
import service.impl.ProblemServiceImpl;
import service.impl.UserServiceImpl;
import strategy.impl.DifficultyFilterStrategyImpl;
import strategy.impl.DifficultySortStrategyImpl;
import strategy.impl.ScoreSortStrategyImpl;

public class HackathonEvent {
    public static void main(String[] args) {
        UserService userService = UserServiceImpl.getInstance();
        ProblemService problemService = ProblemServiceImpl.getInstance();

        //Add new User
        userService.registerUser("Nikhil", "Engineering", "nikhil@gcom");
        userService.registerUser("Sandy", "Marketing", "sandy@gcom");

        //Add new Problem
        Problem problem1 = problemService.addProblem("Problem 1", "Tag1", ProblemDifficulty.EASY, 10);
        Problem problem2 = problemService.addProblem("Problem 2", "Tag2", ProblemDifficulty.MEDIUM, 20);
        Problem problem3 = problemService.addProblem("Problem 3", "Tag3", ProblemDifficulty.HARD, 30);
        Problem problem4 = problemService.addProblem("Problem 4", "Tag4", ProblemDifficulty.EASY, 5);

        problemService.getProblemsSortedByCriteria(new ScoreSortStrategyImpl());
        problemService.getProblemsSortedByCriteria(new DifficultySortStrategyImpl());

        problemService.getProblemsFilteredByCriteria(new DifficultyFilterStrategyImpl());

        userService.solveProblem("nikhil@gcom", problem1);
        userService.solveProblem("nikhil@gcom", problem2);
        userService.solveProblem("sandy@gcom", problem3);
        userService.solveProblem("sandy@gcom", problem4);

        userService.getProblemsSolvedByUser("nikhil@gcom");
        problemService.getCountOfUsersSolvedProblem(problem1);

        User user  = userService.getCurrentLeaderOfContest();
        System.out.println(user.getName() + " " + user.getCurrentScore());


    }
}

