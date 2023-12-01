package baseball.Service;

import baseball.domain.Computer;
import baseball.domain.Input;
import baseball.domain.Result;



public class GameService {

    private final Computer computer;
    private boolean gameOver;

    public GameService(Computer computer) {
        this.computer = computer;
    }

    public void setNewGame() {
        computer.generateAnswer();
        gameOver = false;
    }

    public Result playRound(Input input) {
        Result resultOfRound = getResultOfRound(input);
        gameOverCheck(resultOfRound);
        return resultOfRound;
    }

    private Result getResultOfRound(Input input) {
        return Result.of(computer.calculateStrikeCount(input), computer.calculateBallCount(input));
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void gameOverCheck(Result result) {
        if (result.isThreeStrike()) {
            gameOver = true;
        }
    }
}
