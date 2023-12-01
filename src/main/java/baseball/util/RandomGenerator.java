package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator implements NumberGenerator{

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
