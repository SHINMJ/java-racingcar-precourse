package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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
}