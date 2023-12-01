package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine().trim();
    }

    public static String getRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine().trim();
    }
}
