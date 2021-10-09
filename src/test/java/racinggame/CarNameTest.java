package racinggame;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameTest {

	@Test
	public void 자동차이름_한글영문자_6자실패() throws Exception {
		Assertions.assertThatThrownBy(() -> new CarName("new자동차"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.CAR_NAME_NOT_VALID.getValues());
	}

	@Test
	public void 자동차이름_한글영문자숫자_5자성공() throws Exception {
		String name = "자동차a1";
		Assertions.assertThat(new CarName(name)).isInstanceOf(CarName.class);
	}

	@Test
	public void 특수문자_실패() throws Exception {
	    String name = "자동차@2";
		Assertions.assertThatThrownBy(() -> new CarName(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.CAR_NAME_NOT_VALID.getValues());
	}

	@Test
	public void blank_실패() throws Exception {
		String name = "";
		Assertions.assertThatThrownBy(() -> new CarName(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.CAR_NAME_NOT_VALID.getValues());
	}

	@Test
	public void empty_실패() throws Exception {
		String name = " ";
		Assertions.assertThatThrownBy(() -> new CarName(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.CAR_NAME_NOT_VALID.getValues());

	}
}