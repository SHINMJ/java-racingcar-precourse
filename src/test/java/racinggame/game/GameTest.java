package racinggame.game;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.cars.Car;
import racinggame.common.Messages;

class GameTest {

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
	public void 게임_사용자입력_객체_생성_성공() throws Exception {
		String input = "자동차a1,자동차2,자동차34";
		assertThat(new Game(input)).isInstanceOf(Game.class);
	}
	
	@Test
	public void 사용자_입력_실패_특수문자사용() throws Exception {
		String input = "자동차1,자동차33&자동차1";
		new Game(input);
		assertThat(outContent.toString()).isEqualToIgnoringNewLines(Messages.INPUT_NOT_VALID.getValues());
	}

	@Test
	public void 사용자입력_실패_자동차이름6자이상() throws Exception {
		String input = "자동차1,자동차33,자동차1222";
		new Game(input);
		assertThat(outContent.toString()).isEqualToIgnoringNewLines(Messages.CAR_NAME_NOT_VALID.getValues());
	}

	@Test
	public void 사용자입력_실패_중복된이름() throws Exception {
		String input = "자동차1,자동차33,자동차1";
		new Game(input);
		assertThat(outContent.toString()).isEqualToIgnoringNewLines(Messages.INPUT_DUPLICATE.getValues());
	}

	@Test
	public void 사용자입력_성공_자동차목록_생성_성공() throws Exception {
		String input = "자동차1,자동차2,자동차3";
		Game game = new Game(input);
		assertThat(game.getCars().size()).isEqualTo(3);
		for (Car car: game.getCars()) {
			assertThat(input).contains(car.getCarName());
		}
	}

	@Test
	public void 사용자입력_성공_자동차목록_생성_성공_횟수_음수입력실패() throws Exception {
		String input = "자동차1,자동차2,자동차3";
		Game game = new Game(input);
		assertThat(game.getCars().size()).isEqualTo(3);
		for (Car car: game.getCars()) {
			assertThat(input).contains(car.getCarName());
		}
		game.setCount(-1);
		assertThat(outContent.toString()).isEqualToIgnoringNewLines(Messages.INPUT_COUNT_VALID.getValues());
	}

	@Test
	public void 사용자입력_성공_자동차목록_생성_성공_횟수_0입력실패() throws Exception {
		String input = "자동차1,자동차2,자동차3";
		Game game = new Game(input);
		assertThat(game.getCars().size()).isEqualTo(3);
		for (Car car: game.getCars()) {
			assertThat(input).contains(car.getCarName());
		}
		game.setCount(0);
		assertThat(outContent.toString()).isEqualToIgnoringNewLines(Messages.INPUT_COUNT_VALID.getValues());
	}

}