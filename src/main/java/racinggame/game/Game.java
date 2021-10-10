package racinggame.game;

import static racinggame.common.Constant.*;

import java.util.ArrayList;
import java.util.List;

import racinggame.cars.Car;
import racinggame.cars.Cars;
import racinggame.common.Count;

public class Game {
	private Cars cars;
	private CarInputs inputs;
	private Count count;

	public Game(String input) {
		try {
			this.inputs = new CarInputs(input);

		}catch (IllegalArgumentException ie) {
			System.out.println(ie.getMessage());
		}
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

	public void setCount(int count) {
		this.count = new Count(count);
	}

	public void playGame() {
		for (int i = 0; i < this.count.getCount(); i++) {
			this.cars.moveCars();
			this.cars.printResult();
			System.out.println("");
		}
	}
}
