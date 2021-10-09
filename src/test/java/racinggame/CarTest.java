package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static racinggame.utils.Constant.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.cars.Car;
import racinggame.utils.Messages;

public class CarTest {

	private String carName = "car1";
	private Car car;

	@BeforeEach
	public void setup() {
		car = new Car(carName);
	}

	@Test
	public void 자동차이름_특수문자입력_실패() throws Exception {
		String carName = "car@@";
		assertThatThrownBy(() -> new Car(carName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.CAR_NAME_NOT_VALID.getValues());
	}

	@Test
	public void 자동차생성_성공() throws Exception {
	    assertThat(car.getResult()).isEqualTo(carName+" : ");
	}

	@Test
	public void 자동차_3번_움직임_성공() throws Exception {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(4, 8, 5);

			car.setMovedCar();
			car.setMovedCar();
			car.setMovedCar();
			assertThat(car.getCount()).isEqualTo(3);
			assertThat(car.getResult()).isEqualTo(carName+" : " + getMoveExpression(3));

		}
	}

	@Test
	public void 자동차_3번시도_2_움직임_성공() throws Exception {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(4, 2, 5);

			car.setMovedCar();
			car.setMovedCar();
			car.setMovedCar();
			assertThat(car.getCount()).isEqualTo(2);
			assertThat(car.getResult()).isEqualTo(carName+" : " + getMoveExpression(2));

		}
	}

	private String getMoveExpression(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(MOVE_EXPRESSION);
		}
		return sb.toString();
	}
}
