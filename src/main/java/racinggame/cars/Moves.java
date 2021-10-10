package racinggame.cars;

public class Moves {
	private MoveExpression move;
	private Count moveCount;

	public Moves() {
		this.move = new MoveExpression("");
		this.moveCount = new Count(0);
	}

	/**
	 * 움직임 추가
	 */
	public void addMove() {
		this.move.addMove();
		this.moveCount.addCount();
	}

	public String getMove() {
		return this.move.getMove();
	}

	public int getMoveCount() {
		return this.moveCount.getCount();
	}
}
