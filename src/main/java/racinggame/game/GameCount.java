package racinggame.game;

import racinggame.cars.Messages;

public class GameCount {
	private int gameCount;

	public GameCount(String gameCount) {
		int count = parseIntGameCount(gameCount);
		validGameCount(count);
		this.gameCount = count;
	}

	/**
	 * 양의 정수 체크
	 *
	 * @param count
	 */
	private void validGameCount(int count) {
		if (count < 1) {
			throw new NumberFormatException(Messages.INPUT_COUNT_VALID.getValues());
		}
	}

	/**
	 * 숫자 형식 체크 & 형변환
	 *
	 * @param gameCount
	 * @return
	 */
	private int parseIntGameCount(String gameCount) {
		try {
			return Integer.parseInt(gameCount);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(Messages.INPUT_NUMBER_FORMAT_VALID.getValues());
		}
	}

	public int getGameCount() {
		return this.gameCount;
	}
}
