package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MovesTest {

    @Test
    void 전진횟수_생성() {
        Moves moves = Moves.valueOf(2);
        assertTrue(moves.is(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 1000})
    void 전진횟수_전진성공(int source) {
        Moves moves = Moves.create();
        for (int i = 0; i < source; i++) {
            moves.addMoves();
        }
        assertTrue(moves.is(source));
    }

    @ParameterizedTest
    @CsvSource(value = {"2;--", "10;----------", "1;-"}, delimiter = ';')
    void 전진횟수_문자열출력(int number, String expected) {
        Moves moves = Moves.valueOf(number);
        assertThat(moves.convertExpression()).isEqualTo(expected);
    }
}