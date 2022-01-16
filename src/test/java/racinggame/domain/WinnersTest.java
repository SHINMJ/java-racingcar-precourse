package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    void 우승자_생성() {
        Winners winners = Winners.create(Arrays.asList(Car.of("car1"), Car.of("car2")));
        assertThat(winners.toString()).isEqualTo("car1,car2");
    }
}