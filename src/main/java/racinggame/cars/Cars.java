package racinggame.cars;

import static racinggame.common.Constant.*;

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

	/**
	 * 우승자 이름 return
	 *
	 * @return
	 */
	public String getWinner() {
		sortDesc();

		StringBuilder sb = new StringBuilder();
		sb.append(this.cars.get(0).getCarName());
		int s = this.cars.get(0).getMoveCount();
		for (int i = 1; i < this.cars.size(); i++) {
			getCoWinner(s, this.cars.get(i), sb);
		}
		return sb.toString();
	}

	/**
	 * 공동 우승자 찾기
	 *
	 * @param score
	 * @param car
	 * @param sb
	 */
	private void getCoWinner(int score, Car car, StringBuilder sb) {
		if (score != car.getMoveCount()) {
			return;
		}
		sb.append(ADD_STR);
		sb.append(car.getCarName());
	}
}
