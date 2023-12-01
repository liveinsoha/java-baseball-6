package baseball.domain;


import java.util.List;
import java.util.Objects;

public class Answer {

    private final List<Integer> answer;

    private Answer(List<Integer> numbers) {
        validate(numbers);
        answer = numbers;
    }

    public static Answer of(List<Integer> numbers) {
        return new Answer(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }

    public int getCountOfContain(Input input) {
        return (int) input.getInput().stream().filter(answer::contains).count();
    }

    public int getCountOfCorrectPosition(Input input) {
        int countOfCorrectPosition = 0;
        List<Integer> numbers = input.getInput();
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(numbers.get(i), answer.get(i))) {
                countOfCorrectPosition++;
            }
        }
        return countOfCorrectPosition;
    }
}
