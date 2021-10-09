package racinggame.cars;

import static racinggame.utils.Constant.*;

public class Moves {
	private String move;
	private int moveCount;

	public Moves() {
		this.move = "";
		this.moveCount = 0;
	}

	public void addMove() {
		this.move = this.move + MOVE_EXPRESSION;
		this.moveCount = this.moveCount + 1;
	}

	public String getMove() {
		return this.move;
	}

	public int getMoveCount() {
		return this.moveCount;
	}
}
