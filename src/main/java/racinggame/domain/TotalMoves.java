package racinggame.domain;

import racinggame.exception.BusinessException;
import racinggame.utils.Constants;

public class TotalMoves {
    private static final String TOTAL_MOVE_INPUT_MESSAGE = "[ERROR] 양의 숫자만 입력 가능합니다.";

    private final Integer totalMoves;

    private TotalMoves(String input) {
        validate(input);
        this.totalMoves = parse(input);
    }

    public static TotalMoves of(String input) {
        return new TotalMoves(input);
    }

    public boolean is(Integer other) {
        return this.totalMoves.equals(other);
    }

    public Integer getTotalMoves() {
        return this.totalMoves;
    }

    private void validate(String input) {
        if (parse(input) <= Constants.MOVES_MIN_VALUE) {
            throw new BusinessException(TOTAL_MOVE_INPUT_MESSAGE);
        }
    }

    private Integer parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BusinessException(TOTAL_MOVE_INPUT_MESSAGE);
        }
    }
}
