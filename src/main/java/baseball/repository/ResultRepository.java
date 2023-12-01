package baseball.repository;

import baseball.domain.Result;
import baseball.dto.ResultDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultRepository {

    private static final ResultRepository instance = new ResultRepository();
    private final List<Result> results = new ArrayList<>();
    ;

    private ResultRepository() {
    }

    public static ResultRepository getInstance() {
        return instance;
    }

    public void saveResult(Result result) {
        results.add(result);
    }

    public List<ResultDTO> getResultDTOs() {
        return results.stream().map(Result::toDto).collect(Collectors.toList());
    }

    public void resetGameData() {
        results.clear();
    }
}
