package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class MainController {

    public void run() {
        Cars cars = initGame();
        int trialCount = initTrialCount();
        proceedGame(cars, trialCount);
        endGame(cars);
    }

    private int initTrialCount() {
        return InputView.readTrialCount();
    }

    private Cars initGame() {
        return InputView.readCarNames();
    }

    private void proceedGame(Cars cars, int trialCount) {
    }

    private void endGame(Cars cars) {
    }
}
