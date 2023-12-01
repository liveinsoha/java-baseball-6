package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    void test() {
        Answer answer = Answer.of(List.of(1, 2, 3));
        Input input = Input.of("123");
        assertThat(answer.getCountOfCorrectPosition(input)).isEqualTo(3);
    }

    @Test
    void test2() {
        Answer answer = Answer.of(List.of(1, 2, 3));
        Input input = Input.of("132");
        assertThat(answer.getCountOfContain(input)).isEqualTo(3);
    }

    @Test
    void test3() {
        Answer answer = Answer.of(List.of(1, 2, 3));
        Input input = Input.of("132");
        assertThat(answer.getCountOfCorrectPosition(input)).isEqualTo(1);
    }

}