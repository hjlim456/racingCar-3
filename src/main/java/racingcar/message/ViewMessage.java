package racingcar.message;

public enum ViewMessage {

    INPUT_TRIAL_COUNT_MESSAGE("시도할 횟수는 몇회인가요?"),
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    private final String message;
    ViewMessage(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
