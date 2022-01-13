package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racinggame.exception.BusinessException;

class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차이름생성_공백실패(String input) {
        assertThatThrownBy(() -> CarName.from(input))
            .isInstanceOf(BusinessException.class)
            .hasMessage("1~5자의 이름을 입력해 주세요.");
    }
}