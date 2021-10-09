package racinggame;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameTest {

	@Test
	public void 자동차이름_한글영문자_6자실패() throws Exception {
		Assertions.assertThatThrownBy(() -> new CarName("new자동차"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차이름_한글영문자_5자성공() throws Exception {

	}
}