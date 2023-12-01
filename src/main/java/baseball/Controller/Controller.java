package baseball.Controller;

import baseball.Service.GameService;
import baseball.domain.Computer;
import baseball.domain.Input;
import baseball.domain.Result;
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
        printGameStartMessage();
        try {
            startNewGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startNewGame() {
        do {
            gameService.setNewGame();
            playGame();
        } while (restartGame());
    }


    private void playGame() {
        while (!gameService.isGameOver()) {
            Input input = Input.of(InputView.getUserInput());
            Result result = gameService.playRound(input);
            OutputView.printResultOfRound(result.toDto());
        }
        OutputView.printCongratulation();
    }

    private boolean restartGame() {
        String restartInput = InputView.getRestartInput();
        int restartNumber = validateRestartInput(restartInput);
        return restartNumber == 1;
    }

    private int validateRestartInput(String restartInput) {
        int restartNumber = Parser.parseRestartInput(restartInput);
        if (restartNumber != 1 && restartNumber != 2) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
        return restartNumber;
    }

    private void printGameStartMessage() {
        InputView.printGameStartMessage();
    }
}
