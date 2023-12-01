package baseball.Service;

import baseball.domain.Computer;
import baseball.domain.Input;
import baseball.domain.Result;
import baseball.dto.ResultDTO;
import baseball.repository.ResultRepository;

import java.util.List;


public class GameService {

    private final Computer computer;
    private final ResultRepository resultRepository = ResultRepository.getInstance();
    private int roundCount;
    private boolean gameOver;

    public GameService(Computer computer) {
        this.computer = computer;
    }

    public void setNewGame() {
        computer.generateAnswer();
        resultRepository.resetGameData();
        roundCount = 0;
        gameOver = false;
    }

    public ResultDTO playRound(Input input) {
        roundCount++;
        Result resultOfRound = getResultOfRound(input);
        saveResultOfRound(resultOfRound);
        gameOverCheck(resultOfRound);
        return resultOfRound.toDto();
    }

    public List<ResultDTO> getResultDTOs() {
        return resultRepository.getResultDTOs();
    }

    public int getRoundCount() {
        return roundCount;
    }

    private void saveResultOfRound(Result result) {
        resultRepository.saveResult(result);
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
