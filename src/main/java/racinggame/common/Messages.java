package racinggame.common;

public enum Messages {
	CAR_NAME_NOT_VALID("[ERROR] 한글,영어,숫자 포함 1~5자만 가능합니다."),
	INPUT_NOT_VALID("[ERROR] 한글,영어,숫자와 ','만 입력 가능합니다."),
	INPUT_DUPLICATE("[ERROR] 중복된 이름이 존재합니다."),
	GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	GAME_COUNT("시도할 회수는 몇회인가요?");

	private String values;

	Messages(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}
}
