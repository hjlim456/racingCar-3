package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class MainController {

    public void run() {
        Cars cars = initCars();
        proceedGame(cars);
        endGame(cars);
    }

    private Cars initCars() {
        return InputView.readCarNames();
    }

    private void proceedGame(Cars cars) {
    }

    private void endGame(Cars cars) {
    }
}
