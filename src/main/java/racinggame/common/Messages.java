package racinggame.common;

public enum Messages {
	CAR_NAME_NOT_VALID("[ERROR] 한글,영어,숫자 포함 1~5자만 가능합니다."),
	INPUT_NOT_VALID("[ERROR] 한글,영어,숫자와 ','만 입력 가능합니다."),
	INPUT_DUPLICATE("[ERROR] 중복된 이름이 존재합니다."),
	COUNT_VALID("[ERROR] 0 이상의 양수만 입력 가능합니다."),
	INPUT_NUMBER_FORMAT_VALID("[ERROR] (0~2147483647) 숫자 형식만 입력 가능합니다."),
	INPUT_COUNT_VALID("[ERROR] 1 이상의 양수만 입력 가능합니다."),
	GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	GAME_COUNT("시도할 회수는 몇회인가요?"),
	GAME_RESULT("실행 결과"),
	GAME_END("최종 우승자는 {0} 입니다.");

	private String values;

	Messages(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}
}
