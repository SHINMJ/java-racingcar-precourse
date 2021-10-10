package racinggame.cars;

import static racinggame.cars.Constant.*;

public class MoveExpression {
	private String move;

	public MoveExpression(String move) {
		this.move = move;
	}

	public void addMove() {
		this.move = this.move + MOVE_EXPRESSION;
	}

	public String getMove() {
		return this.move;
	}
}
