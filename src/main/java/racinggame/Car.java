package racinggame;

import static racinggame.Constant.*;

import nextstep.utils.Randoms;

public class Car {
	private CarName carName;
	private Moves moves;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.moves = new Moves();
	}

	private int getRandom() {
		return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
	}

	private boolean isPossibleMove() {
		if (getRandom() < POSSIBLE_MOVE_NUMBER) {
			return false;
		}
		return true;
	}

	public void setMovedCar() {
		if (isPossibleMove()) {
			this.moves.addMove();
		}
	}

	public int getCount() {
		return this.moves.getMoveCount();
	}

	public String getResult() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.carName.getCarName());
		sb.append(" : ");
		sb.append(this.moves.getMove());
		return sb.toString();
	}
}
