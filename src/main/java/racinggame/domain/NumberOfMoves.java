package racinggame.domain;

import static racinggame.utils.Constants.*;

import java.util.Objects;

public class NumberOfMoves {

    private Integer moves;

    private NumberOfMoves(Integer moves) {
        this.moves = moves;
    }

    public static NumberOfMoves create() {
       return new NumberOfMoves(NUMBER_OF_MOVES_INIT);
    }

    public static NumberOfMoves valueOf(Integer number) {
        return new NumberOfMoves(number);
    }

    public void addMoves() {
        this.moves++;
    }

    public boolean is(Integer other) {
        return Objects.equals(this.moves, other);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.moves; i++) {
            sb.append(MOVES_CHARACTER_EXPRESSION);
        }
        return sb.toString();
    }
}
