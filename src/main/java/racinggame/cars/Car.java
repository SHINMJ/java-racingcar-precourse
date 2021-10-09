package racinggame.cars;

import static racinggame.common.Constant.*;

import nextstep.utils.Randoms;

public class Car {
	private CarName carName;
	private Moves moves;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.moves = new Moves();
	}

	/**
	 * 랜덤 숫자
	 *
	 * @return
	 */
	private int getRandom() {
		return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
	}

	/**
	 * 움직일 수 있는지 체크
	 *
	 * @return
	 */
	private boolean isPossibleMove() {
		if (getRandom() < POSSIBLE_MOVE_NUMBER) {
			return false;
		}
		return true;
	}

	/**
	 * 자동차 움직이기
	 *
	 */
	public void setMovedCar() {
		if (isPossibleMove()) {
			this.moves.addMove();
		}
	}

	/**
	 * 움직인 횟수 return
	 *
	 * @return
	 */
	public int getMoveCount() {
		return this.moves.getMoveCount();
	}

	/**
	 * 자동차 상황 return
	 *
	 * @return
	 */
	public String getResult() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.carName.getCarName());
		sb.append(" : ");
		sb.append(this.moves.getMove());
		return sb.toString();
	}
}
