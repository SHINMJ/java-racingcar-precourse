package racinggame;

public enum Messages {
	CAR_NAME_NOT_VALID("한글,영어,숫자 포함 1~5자만 가능합니다.");

	private String values;

	Messages(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}
}
