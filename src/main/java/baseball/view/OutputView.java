package baseball.view;

import baseball.domain.Result;
import baseball.dto.ResultDTO;

public class OutputView {

    public static void printResultOfRound(ResultDTO resultDTO) {
        int ballCount = resultDTO.getBallCount();
        int strikeCount = resultDTO.getStrikeCount();
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        } else if (ballCount == 0) {
            System.out.printf("%d스트라이크 \n", strikeCount);
            return;
        } else if (strikeCount == 0) {
            System.out.printf("%d볼 \n", ballCount);
            return;
        }
        System.out.printf("%d볼 %d스트라이크 \n", ballCount, strikeCount);
    }

    public static void printCongratulation(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
