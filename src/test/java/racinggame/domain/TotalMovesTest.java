package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.BusinessException;

class TotalMovesTest {

    @ParameterizedTest
    @ValueSource(strings = {"2","1","3","22","2147483647"})
    void 사용자입력_총이동_생성(String input) {
        TotalMoves totalMoves = TotalMoves.of(input);
        assertTrue(totalMoves.is(Integer.parseInt(input)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2", "0", "2147483648", "sdd", "신", "2@"})
    void 사용자입력_총이동_실패(String input) {
        assertThatThrownBy(() -> TotalMoves.of(input))
            .isInstanceOf(BusinessException.class)
            .hasMessage("양의 숫자만 입력 가능합니다.");
    }
}