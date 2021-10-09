package racinggame.game;

import java.util.ArrayList;
import java.util.List;

import racinggame.cars.Car;
import racinggame.cars.Cars;
import racinggame.common.Count;
import racinggame.common.Messages;

public class Game {
	private Cars cars;
	private CarInputs inputs;
	private Count count;

	public Game(String input) {
		try {
			this.inputs = new CarInputs(input);

		}catch (IllegalArgumentException ie) {
			System.out.println(Messages.INPUT_ERROR_MESSAGE);
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
	
}
