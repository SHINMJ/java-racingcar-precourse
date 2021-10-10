package racinggame.cars;

public class Count {
	private int count;

	public Count(int count) {
		validCount(count);
		this.count = count;
	}

	/**
	 * positive int 만 가능
	 *
	 * @param count
	 */
	private void validCount(int count) {
		if (count < 0) {
			throw new IllegalArgumentException(Messages.COUNT_VALID.getValues());
		}
	}

	public int getCount() {
		return this.count;
	}

	public void addCount() {
		this.count = this.count+1;
	}
}
