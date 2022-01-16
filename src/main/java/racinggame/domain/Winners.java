package racinggame.domain;

import java.util.List;

public final class Winners {

    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners create(List<Car> winners) {
        return new Winners(winners);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Car car : winners) {
            sb.append(car.toStringCarName());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
