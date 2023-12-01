package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static int parseCharToInt(char c) {
        return c - '0';
    }

    public static List<Integer> parseStringToIntegers(String input) {
        List<Integer> inputs = new ArrayList<>();
        char[] numbers = input.toCharArray();
        for (int i = 0; i < 3; i++) {
            inputs.add(parseCharToInt(numbers[i]));
        }
        return inputs;
    }

    public static int parseRestartInput(String restartInput) {
        try {
            return Integer.parseInt(restartInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }
}
