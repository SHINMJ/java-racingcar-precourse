package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.Constant.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.cars.Moves;

class MovesTest {

	private Moves moves;

	@BeforeEach
	public void setup() {
		moves = new Moves();
	}

	private String getMoveExpression(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(MOVE_EXPRESSION);
		}
		return sb.toString();
	}

	@Test
	public void Moves_전진_3_성공() throws Exception {
		int count = 3;
		for (int i = 0; i < count; i++) {
			moves.addMove();
		}
		assertThat(moves.getMove()).isEqualTo(getMoveExpression(count));
		assertThat(moves.getMoveCount()).isEqualTo(count);
	}

	@Test
	public void 전진_0_성공() throws Exception {
		assertThat(moves.getMove()).isEqualTo("");
		assertThat(moves.getMoveCount()).isEqualTo(0);
	}

}