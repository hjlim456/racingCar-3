package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {
    private static Car carDodo;
    private static Car carGogo;


    @DisplayName("유효한 이름 입력을 받앗을때 기능 성공 테스트")
    @Test
    void createCarsSuccessTest() {
        //given
        String InputStrings = "car1, car2, car3 ";
        List<Car> expectedCarlist= List.of(
                new Car(new CarName("car1")),
                new Car(new CarName("car2")),
                new Car(new CarName("car3"))
        );
        //when
        Cars expectedCars = new Cars(expectedCarlist);
        Cars cars = Cars.createCars(InputStrings);
        //then
        assertThat(cars.toString()).isEqualTo(expectedCars.toString());
    }


    @DisplayName("이름이 중복되거나 빈값이 입력된 경우 실패 테스트")
    @ParameterizedTest
    @MethodSource("failInputString")
    void convertNamesToCarsFailTest(String inputStrings) {
        assertThatThrownBy(() -> Cars.createCars(inputStrings))
                .isInstanceOf(IllegalArgumentException.class);
    }
    static Stream<Arguments> failInputString() {
        return Stream.of(
                Arguments.of("dodo,dodo,dodo"),
                        Arguments.of("dodo,  , ,," )
                 );
    }

}