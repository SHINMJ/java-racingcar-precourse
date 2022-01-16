package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

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

    @Test
    void 자동차_전진() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1,4,7);
            Car car = Car.of("car");
            for (int i = 0; i < 3; i++) {
                car.moveOrStop();
            }
            assertTrue(car.equalsNumberOfMoves(NumberOfMoves.valueOf(2)));
        }
    }
}
