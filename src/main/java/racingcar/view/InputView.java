package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.TrialCount;
import racingcar.message.ErrorMessage;
import racingcar.message.ViewMessage;

public class InputView {
    public static final String SPLIT_DELIMITER = ",";

    public static String readCarNames() {
        System.out.println(ViewMessage.INPUT_TRIAL_COUNT_MESSAGE.getMessage());
        String inputStrings = Console.readLine().trim();
        CarName.validateNotBlank(inputStrings);
        return inputStrings;
    }

    public static int readTrialCount() {
        System.out.println(ViewMessage.INPUT_TRIAL_COUNT_MESSAGE.getMessage());
        String inputStrings = Console.readLine().trim();

        TrialCount.validateNotBlank(inputStrings);
        TrialCount.validateStringisInteger(inputStrings);
        int trialCount = Integer.parseInt(inputStrings);

        TrialCount.validateIsPositiveNumber(trialCount);

        return trialCount;
    }







}
