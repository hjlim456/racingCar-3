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

        //빈값 검증 추가하기
        if(inputStrings.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }

        String[] carNames  = inputStrings.split(",");
        List<Car> cars = Arrays.stream(carNames)
                .map(String::trim)
                .map(CarName::new)
                .map(Car::new)
                .toList();
        //중복검증 추가하기

        return new Cars(cars);
    }

    public static int readTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputStrings = Console.readLine().trim();

        int trialCount = Integer.parseInt(inputStrings);

        return trialCount;
    }

}
