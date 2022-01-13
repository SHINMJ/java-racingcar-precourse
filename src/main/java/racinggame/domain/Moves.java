package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.utils.Constants;

public class Moves {

    private Integer moves;

    private Moves() {
        this.moves = Randoms.pickNumberInRange(Constants.MOVES_MIN_VALUE, Constants.MOVES_MAX_VALUE);
    }

    public static Moves create() {
        return new Moves();
    }

    public boolean isMove() {
        return this.moves >= Constants.MOVES_VALUE;
    }
}
