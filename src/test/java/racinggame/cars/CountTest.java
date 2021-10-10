package racinggame.cars;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountTest {

	@Test
	public void 음수입력_실패() throws Exception {
		assertThatThrownBy(() -> new Count(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.COUNT_VALID.getValues());
	}

}