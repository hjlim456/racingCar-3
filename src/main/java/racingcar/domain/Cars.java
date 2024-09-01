package racingcar.domain;

import java.util.List;

public record Cars(List<Car> carList) {
    public void tryMove() {
        carList.forEach(Car::moveRandomly);
    }
}
