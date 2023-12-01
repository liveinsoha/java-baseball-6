package baseball.domain;

import baseball.util.Parser;

import java.util.Arrays;
import java.util.List;

public class Input {

    List<Integer> input;

    private Input(String userInput) {
        validate(userInput);
        input = Parser.parseStringToIntegers(userInput);
    }

    public static Input of(String userInput) {
        return new Input(userInput);
    }

    private void validate(String userInput) {
        validateUserInputLength(userInput);
        validateUserInputNumber(userInput);
        validateNumberRange(userInput);
        validateDuplicate(userInput);
    }

    private void validateDuplicate(String userInput) {
        if (Parser.parseStringToIntegers(userInput).stream().distinct().count() != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }

    private void validateUserInputLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }

    private void validateUserInputNumber(String userInput) {
        char[] inputs = userInput.toCharArray();
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(inputs[i])) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
            }
        }
    }

    private void validateNumberRange(String userInput) {
        char[] inputs = userInput.toCharArray();
        for (int i = 0; i < 3; i++) {
            int number = Parser.parseCharToInt(inputs[i]);
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
            }
        }
    }

    public List<Integer> getInput() {
        return input;
    }
}
