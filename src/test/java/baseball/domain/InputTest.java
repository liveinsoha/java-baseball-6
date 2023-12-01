package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class InputTest {

    @Test
    void test1() {
        assertThatThrownBy(() -> Input.of("012")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void test2() {
        assertThatThrownBy(() -> Input.of("0123")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void test3() {
        assertThatThrownBy(() -> Input.of("asd")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void successTest() {
        assertThatNoException().isThrownBy(() -> Input.of("198"));
    }

}