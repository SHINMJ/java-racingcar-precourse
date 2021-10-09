package racinggame.cars;

import static racinggame.utils.Constant.*;
import static racinggame.utils.RacingUtils.*;

import java.util.regex.Pattern;

import racinggame.utils.Messages;

public class CarName {
	private String carName;

	public CarName(String carName) {
		validCarName(carName);
		this.carName = carName;
	}

	private void validCarName(String carName) {
		//영문, 한글, 숫자 포함 5자 이하 체크
		if (!findMatches(Pattern.compile(CAR_NAME_REG_EXP), carName)) {
			throw new IllegalArgumentException(Messages.CAR_NAME_NOT_VALID.getValues());
		}
	}

	public String getCarName() {
		return this.carName;
	}
}
