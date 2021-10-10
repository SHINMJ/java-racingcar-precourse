package racinggame.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racinggame.cars.CarName;
import racinggame.common.Messages;

class CarInputsTest {

	@Test
	public void 자동차이름_3대_성공() throws Exception {
		String input = "자동차a1,자동차2,자동차34";
		assertThat(new CarInputs(input)).isInstanceOf(CarInputs.class);
	}

	@Test
	public void 특수문자포함_실패() throws Exception {
		String input = "자동차1,자동차33&자동차1";
		assertThatThrownBy(() -> new CarInputs(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.INPUT_NOT_VALID.getValues());
	}

	@Test
	public void 자동차이름6자이상_실패() throws Exception {
		String input = "자동차1,자동차33,자동차1222";
		assertThatThrownBy(() -> new CarInputs(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.CAR_NAME_NOT_VALID.getValues());
	}

	@Test
	public void 중복된이름_실패() throws Exception {
		String input = "자동차1,자동차33,자동차1";
		assertThatThrownBy(() -> new CarInputs(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.INPUT_DUPLICATE.getValues());
	}

}