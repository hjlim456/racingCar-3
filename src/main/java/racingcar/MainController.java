package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        int triedCount = 0;
        System.out.println("실행 결과");
        while (triedCount < trialCount){
            cars.tryMove();
            triedCount++;

            OutputView.printTryResult(cars);
        }
    }

    private void endGame(Cars cars) {
        List<Car> winnerList = cars.getWinnerList();
        OutputView.printWinners(winnerList);
    }
}
