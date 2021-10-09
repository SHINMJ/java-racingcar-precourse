package racinggame.common;

import static racinggame.common.Constant.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingUtils {

	public static boolean findMatches(Pattern pattern, CharSequence input) {
		Matcher m = pattern.matcher(input);
		return m.find();
	}

	public static void validCarName(String carName) {
		//영문, 한글, 숫자 포함 5자 이하 체크
		if (!findMatches(Pattern.compile(CAR_NAME_REG_EXP), carName)) {
			throw new IllegalArgumentException(Messages.CAR_NAME_NOT_VALID.getValues());
		}
	}
}
