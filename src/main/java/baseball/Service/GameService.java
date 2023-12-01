package baseball.Service;

import baseball.domain.Computer;
import baseball.domain.Input;
import baseball.domain.Result;
import baseball.util.RandomGenerator;
import baseball.view.InputView;

public class GameService {

    Computer computer = new Computer(new RandomGenerator());

    public void startGame() {
        computer.generateAnswer();
    }

    public Result playRound() {
        Input input = Input.of(InputView.getUserInput());
        return getResultOfRound(input);
    }

    private Result getResultOfRound(Input input) {
        return Result.of(computer.calculateStrikeCount(input), computer.calculateBallCount(input));
    }

    public boolean isGameOver(Result result) {
        return result.isThreeStrike();
    }
}
