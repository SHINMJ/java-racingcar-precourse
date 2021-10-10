package racinggame.common;

public class Count {
	private int count;

	public Count(int count, boolean zero) {
		validCount(count, zero);
		this.count = count;
	}

	/**
	 * positive int 만 가능
	 *
	 * @param count
	 */
	private void validCount(int count, boolean zero) {
		int n = zero ? 0 : 1;
		if (count < n) {
			throw new IllegalArgumentException(Messages.INPUT_COUNT_VALID.getValues());
		}
	}

	public int getCount() {
		return this.count;
	}

	public void addCount() {
		this.count = this.count+1;
	}
}
