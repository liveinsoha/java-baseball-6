package baseball.Controller;

import baseball.Service.GameService;
import baseball.domain.Input;
import baseball.domain.Result;
import baseball.util.Parser;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    GameService gameService = new GameService();

    public void run() {
        printGameStartMessage();
        try {
            startNewGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startNewGame() {
        do {
            gameService.startGame();
            playGame();
        } while (Parser.ParseRestartInput(InputView.getRestartInput()) == 1);
    }

    private void playGame() {
        Result result;
        do {
            result = gameService.playRound();
            OutputView.printResultOfRound(result.toDto());
        } while (!gameService.isGameOver(result));
        OutputView.printCongratulation();
    }

    private void printGameStartMessage() {
        InputView.printGameStartMessage();
    }
}
