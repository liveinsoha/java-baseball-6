package baseball.view;

import baseball.domain.Result;
import baseball.dto.ResultDTO;

import java.util.List;

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

    public static void printCongratulation() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printTrialCount(int roundCount) {
        System.out.printf("총 시도횟수 :  %d회 \n", roundCount);
    }

    public static void printResultOfGame(List<ResultDTO> resultDTOS) {
        for (int i = 0; i < resultDTOS.size(); i++) {
            System.out.printf("%d라운드 : ", i + 1);
            printResultOfRound(resultDTOS.get(i));
        }
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
