package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.Arrays;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

public class MovesTest {

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:true", "9:true", "0:false"}, delimiter = ':')
    void 이동여부(int value, boolean expected) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(value);
            Moves moves = Moves.create();
            assertThat(moves.isMove()).isEqualTo(expected);
        }
    }
}
