package racinggame.cars;

import static racinggame.common.Constant.*;

import racinggame.common.Count;

public class Moves {
	private String move;
	private Count moveCount;

	public Moves() {
		this.move = "";
		this.moveCount = new Count(0);
	}

	public void addMove() {
		this.move = this.move + MOVE_EXPRESSION;
		this.moveCount.addCount();
	}

	public String getMove() {
		return this.move;
	}

	public int getMoveCount() {
		return this.moveCount.getCount();
	}
}
