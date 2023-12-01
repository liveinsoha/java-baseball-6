package baseball.domain;

import baseball.dto.ResultDTO;

public class Result {

    private final int strikeCount;
    private final int ballCount;

    private Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Result of(int strikeCount, int ballCount) {
        return new Result(strikeCount, ballCount);
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

    public ResultDTO toDto() {
        return ResultDTO.of(strikeCount, ballCount);
    }
}
