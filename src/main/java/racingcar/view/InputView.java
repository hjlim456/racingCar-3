package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.message.ErrorMessage;

public class InputView {

    public static Cars readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStrings = Console.readLine().trim();

        //빈값 입력시 검증
        if(inputStrings.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }


        String[] carNames  = inputStrings.split(",");
        List<Car> cars = Arrays.stream(carNames)
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .map(CarName::new)
                .map(Car::new)
                .toList();
        //중복검증 추가하기
        Set<String> uniqueNames = new HashSet<>();
        cars.stream()
                .map(Car::getName)
                .filter(name-> !uniqueNames.add(name))
                .findAny()
                .ifPresent(duplicatedName->{
                    throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATED_NAME.getMessage());
                });


        return new Cars(cars);
    }

    public static int readTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputStrings = Console.readLine().trim();
        // 빈값 검증
        if (inputStrings.isBlank() || inputStrings == null) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }

        int trialCount;
        //숫자가 아닌 문자 검증
        try {
            trialCount = Integer.parseInt(inputStrings);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER.getMessage());
        }

        //0또는 음수
        if (trialCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_WRONG_VALUE.getMessage());
        }

        return trialCount;
    }

}
