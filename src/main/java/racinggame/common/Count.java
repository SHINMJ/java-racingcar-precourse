package racinggame.common;

public class Count {
	private int count;

	public Count(int count) {
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}

	public void addCount() {
		this.count = this.count+1;
	}
}
