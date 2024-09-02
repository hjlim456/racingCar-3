package racingcar.message;

public enum ErrorMessage {

    EXCESSED_NAME_LENGTH("5글자 이하의 이름을 입력해주세요"),
    INPUT_EMPTY("빈값을 입력 하셨습니다."),
    INPUT_DUPLICATED_NAME("중복된 이름은 입력할 수 없습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
