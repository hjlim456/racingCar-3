package racingcar.domain;

import racingcar.message.ErrorMessage;

public class CarName {
    private final static int MAX_NAME_LENGTH = 5;

    private final String name ;


    public CarName(String name) {
        validateNameLength();
        this.name = name;
    }

    private void validateNameLength() {
        if (name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.EXCESSED_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
