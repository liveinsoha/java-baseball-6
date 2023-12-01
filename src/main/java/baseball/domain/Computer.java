package baseball.domain;

import baseball.util.AnswerGenerator;


public class Computer {

    private final AnswerGenerator answerGenerator;
    private Answer answer;

    public Computer(AnswerGenerator generator) {
        this.answerGenerator = generator;
    }

    public void generateAnswer() {
        answer = Answer.of(answerGenerator.generateAnswer());
    }


    public int calculateBallCount(Input input) {
        return answer.getCountOfContain(input) - answer.getCountOfCorrectPosition(input);
    }

    public int calculateStrikeCount(Input input) {
        return answer.getCountOfCorrectPosition(input);
    }
}
