package racinggame.game;

import static racinggame.common.Constant.*;

import java.util.ArrayList;
import java.util.List;

import racinggame.cars.Car;
import racinggame.cars.Cars;
import racinggame.common.Messages;

public class Game {
	private Cars cars;
	private CarInputs inputs;
	private GameCount gameCount;

	public Game(String input) {
		this.inputs = new CarInputs(input);
		createCars(this.inputs.getInput().split(SPLIT_STR));
	}

	private void createCars(String[] inputs) {
		List<Car> carList = new ArrayList<>();
		for (String i : inputs) {
			carList.add(new Car(i));
		}
		setCars(carList);
	}

	private void setCars(List<Car> carList) {
		this.cars = new Cars(carList);
	}

	public List<Car> getCars() {
		return cars.getCars();
	}

	public void setCount(String count) {
		this.gameCount = new GameCount(count);
	}

	public void playGame() {
		System.out.println(Messages.GAME_RESULT.getValues());
		for (int i = 0; i < this.gameCount.getGameCount(); i++) {
			this.cars.moveCars();
			this.cars.printResult();
			System.out.println("");
		}
		System.out.println(Messages.GAME_END.getValues().replace("{0}", this.cars.getWinner()));
	}

}
