package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer(() -> List.of(1, 2, 3));
        computer.generateAnswer();
    }

    @Test
    void test1() {
        assertThat(computer.calculateStrikeCount(Input.of("123"))).isEqualTo(3);
        assertThat(computer.calculateBallCount(Input.of("123"))).isEqualTo(0);
    }

    @Test
    void test2() {
        assertThat(computer.calculateStrikeCount(Input.of("153"))).isEqualTo(2);
        assertThat(computer.calculateBallCount(Input.of("153"))).isEqualTo(0);
    }

    @Test
    void test3() {
        assertThat(computer.calculateStrikeCount(Input.of("321"))).isEqualTo(1);
        assertThat(computer.calculateBallCount(Input.of("321"))).isEqualTo(2);
    }

    @Test
    void test4() {
        assertThat(computer.calculateStrikeCount(Input.of("456"))).isEqualTo(0);
        assertThat(computer.calculateBallCount(Input.of("456"))).isEqualTo(0);
    }
}