package racinggame.game;

import static racinggame.cars.Constant.*;
import static racinggame.cars.RacingUtils.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

import racinggame.cars.Messages;

public class CarInputs {
	private String input;

	public CarInputs(String input) {
		validCarInputs(input);
		this.input = input;
	}

	/**
	 * 영어,한글,숫자,',' validation check
	 *
	 * @param input
	 */
	private void validCarInputs(String input) {
		//영어,한글,숫자,',' 만 포함, ','로 나뉘는 단어는 1~5자 체크
		if (!findMatches(Pattern.compile(INPUT_REG_EXP), input)) {
			throw new IllegalArgumentException(Messages.INPUT_NOT_VALID.getValues());
		}
		String[] s = input.split(SPLIT_STR);
		validCarNames(s);
		validDuplicateCheck(s);
	}

	/**
	 * split 된 자동차 이름 validation check
	 *
	 * @param inputs
	 */
	private void validCarNames(String[] inputs) {
		for (String i : inputs) {
			validCarName(i);
		}
	}

	/**
	 * 중복된 자동차 이름이 있는지 validation check
	 *
	 * @param inputs
	 */
	private void validDuplicateCheck(String[] inputs) {
		Set<String> s = new LinkedHashSet<>(Arrays.asList(inputs));
		if (s.size() != inputs.length) {
			throw new IllegalArgumentException(Messages.INPUT_DUPLICATE.getValues());
		}
	}

	public String getInput() {
		return this.input;
	}

}
