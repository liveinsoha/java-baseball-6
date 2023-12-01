package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    static public int parseCharToInt(char c) {
        return c - '0';
    }

    static public List<Integer> parseStringToIntegers(String input) {
        List<Integer> inputs = new ArrayList<>();
        char[] numbers = input.toCharArray();
        for (int i = 0; i < 3; i++) {
            inputs.add(parseCharToInt(numbers[i]));
        }
        return inputs;
    }
}
