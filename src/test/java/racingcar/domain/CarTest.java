package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("true가 입력됐을시 전진하는지 테스트")
    @Test
    void moveForwardIfTrue() {
        //given
        Car car1 = new Car(new CarName("car1"));
        //when
        car1.moveForwardIfTrue(true);
        //then
        Assertions.assertThat(car1.getPosition()).isEqualTo(1);
    }
}