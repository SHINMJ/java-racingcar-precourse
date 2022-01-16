package racinggame.domain;

import static racinggame.utils.Constants.MOVES_CHARACTER_EXPRESSION;
import static racinggame.utils.Constants.NUMBER_OF_MOVES_INIT;

import java.util.Objects;

public class NumberOfMoves {

    private Integer numberOfMoves;

    private NumberOfMoves(Integer numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public static NumberOfMoves create() {
        return new NumberOfMoves(NUMBER_OF_MOVES_INIT);
    }

    public static NumberOfMoves valueOf(Integer numberOfMoves) {
        return new NumberOfMoves(numberOfMoves);
    }

    public NumberOfMoves getNumberOfMoves() {
        return NumberOfMoves.valueOf(this.numberOfMoves);
    }

    public void addMoves() {
        this.numberOfMoves++;
    }

    public boolean is(Integer other) {
        return Objects.equals(this.numberOfMoves, other);
    }

    public int compare(NumberOfMoves other) {
        if (this.numberOfMoves < other.numberOfMoves) {
            return 1;
        }

        if (this.numberOfMoves > other.numberOfMoves) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberOfMoves that = (NumberOfMoves) o;
        return numberOfMoves.equals(that.numberOfMoves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfMoves);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.numberOfMoves; i++) {
            sb.append(MOVES_CHARACTER_EXPRESSION);
        }
        return sb.toString();
    }
}
