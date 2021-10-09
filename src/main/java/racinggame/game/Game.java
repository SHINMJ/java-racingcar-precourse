package racinggame.game;

import java.util.List;

import racinggame.cars.Car;
import racinggame.cars.Cars;

public class Game {
	private Cars cars;

	public Game() {
	}

	public void setCars(List<Car> carList) {
		this.cars = new Cars(carList);
	}
}
