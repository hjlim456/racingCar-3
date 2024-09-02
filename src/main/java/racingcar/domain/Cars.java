package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.message.ErrorMessage;
import racingcar.view.InputView;

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

    public static Cars createCars(String inputStrings) {
        List<Car> cars = createNameToCarList(inputStrings);
        validateDuplicatedName(cars);

        return new Cars(cars);
    }
    private static List<Car> createNameToCarList(String inputStrings) {
        String[] carNames  = inputStrings.split(InputView.SPLIT_DELIMITER);
        List<Car> cars = Arrays.stream(carNames)
                .map(String::trim)
                .map(CarName::new)
                .map(Car::new)
                .toList();
        return cars;
    }

    private static void validateDuplicatedName(List<Car> cars) {
        Set<String> uniqueNames = new HashSet<>();
        cars.stream()
                .map(Car::getName)
                .filter(name-> !uniqueNames.add(name))
                .findAny()
                .ifPresent(duplicatedName->{
                    throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATED_NAME.getMessage());
                });
    }
}
