package baseball.Controller;

import baseball.Service.GameService;
import baseball.domain.Computer;
import baseball.domain.Input;
import baseball.domain.Result;
import baseball.dto.ResultDTO;
import baseball.util.Parser;
import baseball.util.RandomAnswerGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    GameService gameService;

    public Controller() {
        Computer computer = new Computer(new RandomAnswerGenerator());
        this.gameService = new GameService(computer);
    }

    public void run() {
        InputView.printGameStartMessage();
        do {
            gameService.setNewGame();
            playGame();
        } while (restartGame());
    }


    private void playGame() {
        do {
            ResultDTO resultDTO = gameService.playRound(getInput());
            OutputView.printResultOfRound(resultDTO);
        } while (!gameService.isGameOver());
        OutputView.printCongratulation();
        OutputView.printTrialCount(gameService.getRoundCount());
        OutputView.printResultOfGame(gameService.getResultDTOs());
    }

    private Input getInput() {
        try {
            return Input.of(InputView.getUserInput());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getInput();
        }
    }

    private boolean restartGame() {
        try {
            return getRestartInput() == 1;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return restartGame();
        }
    }

    private int getRestartInput() {
        String restartInput = InputView.getRestartInput();
        return validateRestartInput(restartInput);
    }

    private int validateRestartInput(String restartInput) {
        int restartNumber = Parser.parseRestartInput(restartInput);
        if (restartNumber != 1 && restartNumber != 2) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
        return restartNumber;
    }

}
