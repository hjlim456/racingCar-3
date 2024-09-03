package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    public static boolean isTrueWith60percent() {
        return (Randoms.pickNumberInRange(0, 9) >= 4);
    }
}
