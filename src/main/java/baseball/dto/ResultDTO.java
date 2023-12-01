package baseball.dto;

public class ResultDTO {

    private final int strikeCount;
    private final int ballCount;

    private ResultDTO(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static ResultDTO of(int strikeCount, int ballCount) {
        return new ResultDTO(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }


}
