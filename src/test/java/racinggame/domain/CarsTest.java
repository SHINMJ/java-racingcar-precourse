package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racinggame.exception.BusinessException;

class CarsTest {

    @Test
    void 자동차목록_사용자입력_생성() {
        Cars cars = Cars.of("tls,222,shin,dsf3s,신명진");
        assertThat(cars.size()).isEqualTo(5);
    }

    @Test
    void 자동차목록_중복체크() {
        assertThatThrownBy(() -> Cars.of("신명진,신명진"))
            .isInstanceOf(BusinessException.class)
            .hasMessage("자동차 이름이 중복되었습니다.");
    }

    @Test
    void 자동차_레이싱() {
        Cars cars = Cars.of("car1,car2,car3");
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1,4,7);
            cars.racing(TotalMoves.of("1"));
            Winners winners = cars.winner();
            assertThat(winners.toString()).isEqualTo("car2,car3");
        }
    }
}