package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Answer {

    List<Integer> answer;

    private Answer(List<Integer> numbers) {
        validateRange(numbers);
        answer = numbers;
    }

    public static Answer of(List<Integer> numbers) {
        return new Answer(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException();
        }
    }

    public int getCountOfContain(Input input) {
        return (int) input.getInput().stream().filter(number -> answer.contains(number)).count();
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
