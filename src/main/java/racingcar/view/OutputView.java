package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public static void printTryResult(Cars cars) {
        System.out.println();
        cars.getCarPositionResult();

    }

    public static void printWinners(List<Car> winnerList) {
        String winnersString = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(InputView.SPLIT_DELIMITER+" "));

        System.out.println();
        System.out.println("최종 우승자 : " + winnersString);
    }
}
