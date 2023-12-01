package baseball.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {


    @Test
    void parseCharToIntTest() {
        assertThat(Parser.parseCharToInt('2')).isEqualTo(2);
    }
}