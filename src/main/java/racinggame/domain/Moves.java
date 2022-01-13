package racinggame.domain;

import static racinggame.utils.Constants.*;

import java.util.Objects;

public class Moves {

    private Integer moves;

    private Moves(Integer moves) {
        this.moves = moves;
    }

    public static Moves create() {
       return new Moves(NUMBER_OF_MOVES_INIT);
    }

    public static Moves valueOf(Integer number) {
        return new Moves(number);
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
