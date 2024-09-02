package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.message.ErrorMessage;
import racingcar.message.ViewMessage;

public class InputView {
    public static final String SPLIT_DELIMITER = ",";

    public static String readCarNames() {
        System.out.println(ViewMessage.INPUT_TRIAL_COUNT_MESSAGE.getMessage());
        String inputStrings = Console.readLine().trim();
        validateNotBlank(inputStrings);
        return inputStrings;
    }



    public static int readTrialCount() {
        System.out.println(ViewMessage.INPUT_TRIAL_COUNT_MESSAGE.getMessage());
        String inputStrings = Console.readLine().trim();

        validateNotBlank(inputStrings);
        validateStringisInteger(inputStrings);
        int trialCount = Integer.parseInt(inputStrings);

        validateIsPositiveNumber(trialCount);

        return trialCount;
    }

    private static void validateIsPositiveNumber(int trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_WRONG_VALUE.getMessage());
        }
    }

    private static void validateNotBlank(String inputStrings) {
        if (inputStrings.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
    }
    private static void validateStringisInteger(String inputStrings) {
        try {
            int trialCount = Integer.parseInt(inputStrings);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER.getMessage());
        }
    }


}
