package racinggame.cars;

import java.util.Collections;
import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	/**
	 * 각 턴마다 결과 print
	 */
	public void printResult() {
		for (Car car : this.cars) {
			System.out.println(car.getResult());
		}
	}

	/**
	 * 한 턴 움직이기
	 */
	public void moveCars() {
		for (Car car : this.cars) {
			car.setMovedCar();
		}
	}

	/**
	 * 내림차순 정렬
	 */
	public void sortDesc() {
		Collections.sort(this.cars, (a, b) -> b.getMoveCount() - a.getMoveCount());
	}
}
