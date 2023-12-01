package baseball.Service;

import baseball.domain.Computer;
import baseball.domain.Input;
import baseball.dto.ResultDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class GameServiceTest {

    Computer computer = new Computer(() -> List.of(1, 2, 3));

    GameService gameService = new GameService(computer);

    @Test
    void test1() {
        Input input = Input.of("123");
        gameService.setNewGame();
        ResultDTO resultDTO = gameService.playRound(input).toDto();
        assertThat(resultDTO.getBallCount()).isEqualTo(0);
        assertThat(resultDTO.getStrikeCount()).isEqualTo(3);
        assertThat(gameService.isGameOver()).isTrue();
    }

    @Test
    void test2() {
        Input input = Input.of("134");
        gameService.setNewGame();
        ResultDTO resultDTO = gameService.playRound(input).toDto();
        assertThat(resultDTO.getBallCount()).isEqualTo(1);
        assertThat(resultDTO.getStrikeCount()).isEqualTo(1);
        assertThat(gameService.isGameOver()).isFalse();
    }

}