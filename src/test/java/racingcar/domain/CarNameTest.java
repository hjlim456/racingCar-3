package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;

class CarNameTest {
    private static final int MAX_NAME_LENGTH = 5;

    @DisplayName("유효한 자동차 이름들이 입력될 때 정상적으로 처리가 되는지 확인.")
    @ParameterizedTest
    @ValueSource(strings = {"dodo", "gogo", "12345"})
    void CarNameSuccessTest(String name) {
        //given
        Car car1 = new Car(new CarName(name));
        //when

        //then
        assertThat(car1.getName()).isEqualTo(name);
    }
    @DisplayName("유효하지않은 자동차 이름들이 입력될 때 에러 처리 확인")
    @ParameterizedTest
    @ValueSource(strings = {"12345678", "", "      "})
    void CarNameFailTest(String name) {
        //given
        //when

        //then
        assertThatThrownBy(() -> {
            new Car(new CarName(name));
        }).isInstanceOf(IllegalArgumentException.class);
    }


}