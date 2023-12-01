package baseball.domain;

import baseball.util.Parser;

import java.util.Arrays;
import java.util.List;

public class Input {

    private final List<Integer> input;

    private Input(String userInput) {
        input = validate(userInput);
    }

    public static Input of(String userInput) {
        return new Input(userInput);
    }

    private List<Integer> validate(String userInput) {
        validateUserInputLength(userInput);
        List<Integer> numbers = Parser.parseStringToIntegers(userInput);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        return numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }

    private void validateUserInputLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }

    public List<Integer> getInput() {
        return input;
    }
}
