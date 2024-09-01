package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static void readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStrings = Console.readLine().trim();

        String[] carNames  = inputStrings.split(",");
        List<String> list = Arrays.stream(carNames)
                .map(String::trim)
                .toList();
    }

}
