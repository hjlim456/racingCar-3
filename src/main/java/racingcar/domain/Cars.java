package racingcar.domain;

import java.util.List;

public record Cars(List<Car> carList) {
    public void tryMove() {
        carList.forEach(Car::moveRandomly);
    }

    public void getCarPositionResult() {
        carList.forEach(car -> System.out.println(car.printPosition()));
    }
}
