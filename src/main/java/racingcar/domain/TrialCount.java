package racingcar.domain;

import racingcar.message.ErrorMessage;

public class TrialCount {
    private final int trialCount ;

    public TrialCount(int trialCount) {
        this.trialCount = trialCount;
    }

    public static void validateIsPositiveNumber(int trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_WRONG_VALUE.getMessage());
        }
    }
    public static void validateStringisInteger(String inputStrings) {
        try {
            int trialCount = Integer.parseInt(inputStrings);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER.getMessage());
        }
    }
    public static void validateNotBlank(String inputStrings) {
        if (inputStrings.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
    }
}
