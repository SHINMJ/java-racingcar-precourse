package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"car;2;car : --", "자동차;4;자동차 : ----"}, delimiter = ';')
    void 자동차생성_출력(String name, Integer moves, String expected) {
        Car car = Car.of(name);
        for (int i = 0; i < moves; i++) {
            car.addMoves();
        }
        assertThat(car.toString()).isEqualTo(expected);
    }
}
