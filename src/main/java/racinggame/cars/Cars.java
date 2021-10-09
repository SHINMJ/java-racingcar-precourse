package racinggame.cars;

import java.util.List;

import racinggame.cars.Car;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void printResult() {
		for (Car car : this.cars) {
			System.out.println(car.getResult());
		}
	}

	public void moveCars() {
		for (Car car : this.cars) {
			car.setMovedCar();
		}
	}
}
