package racingcar.message;

public enum ErrorMessage {

    EXCESSED_NAME_LENGTH("5글자 이하의 이름을 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
