package baseball.domain;

import baseball.util.NumberGenerator;
import baseball.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final NumberGenerator numberGenerator;
    private Answer answer;

    public Computer(NumberGenerator generator) {
        this.numberGenerator = generator;
    }

    public void generateAnswer() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = numberGenerator.generate();
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        answer = Answer.of(numbers);
    }


    public int calculateBallCount(Input input) {
        return answer.getCountOfContain(input) - answer.getCountOfCorrectPosition(input);
    }

    public int calculateStrikeCount(Input input) {
        return answer.getCountOfCorrectPosition(input);
    }
}
