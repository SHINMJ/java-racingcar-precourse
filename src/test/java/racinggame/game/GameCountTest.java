package racinggame.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racinggame.common.Messages;

class GameCountTest {

	@Test
	public void 숫자형식입력_실패() throws Exception {
		assertThatThrownBy(() -> new GameCount("abc"))
			.isInstanceOf(NumberFormatException.class)
			.hasMessage(Messages.INPUT_NUMBER_FORMAT_VALID.getValues());
	}

	@Test
	public void 음수입력_실패() throws Exception {
		assertThatThrownBy(() -> new GameCount("-2"))
			.isInstanceOf(NumberFormatException.class)
			.hasMessage(Messages.INPUT_COUNT_VALID.getValues());
	}

	@Test
	public void zero_성공() throws Exception {
		assertThat(new GameCount("0001").getGameCount()).isEqualTo(1);
	}

}