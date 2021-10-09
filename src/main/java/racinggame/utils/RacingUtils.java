package racinggame.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingUtils {

	public static boolean findMatches(Pattern pattern, CharSequence input) {
		Matcher m = pattern.matcher(input);
		return m.find();
	}
}
