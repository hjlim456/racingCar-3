package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {
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
    @ValueSource(strings = {"dodo,dodo,dodo", "dodo,  , ,," , "12345,dododododo"})
    void convertNamesToCarsFailTest(String inputStrings) {
        assertThatThrownBy(() -> Cars.createCars(inputStrings))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("단일 우승자 선정테스트")
    @Test
    void getWinnerTest() {
        //given
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));
        Cars cars = new Cars(List.of(car1, car2, car3));
        //when
        car1.moveForwardIfTrue(true);
        car2.moveForwardIfTrue(false);
        car3.moveForwardIfTrue(false);

        List<Car> winnerList = cars.getWinnerList();
        List<Car> expectedList = List.of(car1);
        //then
        assertThat(winnerList).isEqualTo(expectedList);
    }
    @DisplayName("복수 우승자 선정 테스트")
    @Test
    void getWinnersTest() {
        //given
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));
        Cars cars = new Cars(List.of(car1, car2, car3));
        //when
        car1.moveForwardIfTrue(true);
        car2.moveForwardIfTrue(true);
        car3.moveForwardIfTrue(false);

        List<Car> winnerList = cars.getWinnerList();
        List<Car> expectedList = List.of(car1, car2);
        //then
        assertThat(winnerList).isEqualTo(expectedList);
    }

}
