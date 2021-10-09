package racinggame;

import static racinggame.Constant.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarName {
	private String carName;

	public CarName(String carName) {
		validCarName(carName);
		this.carName = carName;
	}

	private void validCarName(String carName) {
		//영문, 한글, 숫자 포함 5자 이하 체크
		if (!findMatches(Pattern.compile(REG_EXP), carName)) {
			throw new IllegalArgumentException(Messages.CAR_NAME_NOT_VALID.getValues());
		}
	}

	private boolean findMatches(Pattern pattern, CharSequence input) {
		Matcher m = pattern.matcher(input);
		return m.find();
	}

	public String getCarName() {
		return this.carName;
	}
}
