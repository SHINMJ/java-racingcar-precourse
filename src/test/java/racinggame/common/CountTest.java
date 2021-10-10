package racinggame.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountTest {

	@Test
	public void 음수입력_실패() throws Exception {
		assertThatThrownBy(() -> new Count(-1, false))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.INPUT_COUNT_VALID.getValues());
	}

	@Test
	public void 카운트_0입력_실패() throws Exception {
		assertThatThrownBy(() -> new Count(0, false))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.INPUT_COUNT_VALID.getValues());
	}

}