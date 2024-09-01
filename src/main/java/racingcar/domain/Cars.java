package racingcar.domain;

import java.util.Comparator;
import java.util.List;

public record Cars(List<Car> carList) {
    public void tryMove() {
        carList.forEach(Car::moveRandomly);
    }

    public void getCarPositionResult() {
        carList.forEach(car -> System.out.println(car.printPosition()));
    }

    public List<Car> getWinnerList() {
        int winnerPosition = carList.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElse(0);


        return carList.stream()
                .filter(car -> car.getPosition()==winnerPosition)
                .toList();
    }
}
