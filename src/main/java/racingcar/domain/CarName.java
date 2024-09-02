package racingcar.domain;

import racingcar.message.ErrorMessage;
import racingcar.view.InputView;

public class CarName {
    private final static int MAX_NAME_LENGTH = 5;

    private final String name ;


    public CarName(String name) {
        this.name = name;
        validateNameLength();
        validateNotBlank(name);
    }

    private void validateNameLength() {
        if (name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.EXCESSED_NAME_LENGTH.getMessage());
        }
    }
    public static void validateNotBlank(String inputStrings) {
        if (inputStrings.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
    }



    public String getName() {
        return name;
    }
}
