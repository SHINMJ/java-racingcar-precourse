package racinggame;

import static racinggame.Constant.*;

public class Moves {
	private String move;

	public Moves() {
		this.move = "";
	}

	public void addMove() {
		this.move = this.move + MOVE_EXPRESSION;
	}

	public String getMove() {
		return this.move;
	}
}
