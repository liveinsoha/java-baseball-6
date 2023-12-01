package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
