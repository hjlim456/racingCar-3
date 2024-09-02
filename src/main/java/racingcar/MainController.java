package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

    public class MainController {

        public void run() {
            Cars cars = initCar();
            int trialCount = initTrialCount();
            proceedGame(cars, trialCount);
            endGame(cars);
        }

    private int initTrialCount() {
        return InputView.readTrialCount();
    }

    private Cars initCar() {
        String inputString = InputView.readCarNames();
        Cars cars = Cars.createCars(inputString);
        return cars;
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
