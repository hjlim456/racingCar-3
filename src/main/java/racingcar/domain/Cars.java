package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

    public static Cars createCars(String carNames) {
        List<Car> carList = splitByDelimiter(carNames);
        validateDuplicatedName(carList);

        return new Cars(carList);
    }
    public static List<Car> splitByDelimiter(String inputStrings) {
        String[] carNames  = inputStrings.split(InputView.SPLIT_DELIMITER);

        List<Car> carList = Arrays.stream(carNames)
                .map(String::trim)
                .map(CarName::new)
                .map(Car::new)
                .toList();
        return carList;
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

    @Override
    public String toString() {
        return carList.stream()
                .map(Car::printPosition)
                .collect(Collectors.joining("\n"));
    }


}
