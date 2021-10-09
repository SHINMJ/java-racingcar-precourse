package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.cars.Car;
import racinggame.cars.Cars;

class CarsTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void 자동차_일급컬렉션_게임_3_성공() throws Exception {
		Cars cars = new Cars(Arrays.asList(
			new Car("car1"),
			new Car("car2")
		));

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(4, 8, 5, 2,6,9);

			cars.moveCars();
			cars.moveCars();
			cars.moveCars();
			cars.printResult();
			assertThat(outContent.toString()).isEqualToIgnoringNewLines("car1 : ---car2 : --");
		}
	}
}