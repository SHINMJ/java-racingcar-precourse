package racinggame.utils;

import java.util.regex.Pattern;

public class Constants {
    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final int CAR_NAME_NIN_LENGTH = 1;
    public static final int NUMBER_OF_MOVES_INIT = 0;
    public static final char MOVES_CHARACTER_EXPRESSION = '-';

    public static final int MOVES_MIN_VALUE = 0;
    public static final int MOVES_MAX_VALUE = 9;
    public static final int MOVES_VALUE = 4;

    public static final String CAR_NAME_SPLIT_DELIMITER = ",";

    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]*$");

    public static final int ZERO_INDEX = 0;

}
