package racinggame.domain;

public class Car implements Comparable<Car> {

    private CarName carName;
    private NumberOfMoves numberOfMoves;

    private Car(String carName) {
        this.carName = CarName.from(carName);
        this.numberOfMoves = NumberOfMoves.create();
    }

    public static Car of(String carName) {
        return new Car(carName);
    }

    public void addMoves() {
        this.numberOfMoves.addMoves();
    }

    public void moveOrStop() {
        Moves moves = Moves.create();
        if (moves.isMove()) {
            addMoves();
        }
    }

    public boolean equalsNumberOfMoves(NumberOfMoves numberOfMoves) {
        return this.numberOfMoves.equals(numberOfMoves);
    }

    public String toStringCarName() {
        return this.carName.toString();
    }

    public NumberOfMoves getNumberOfMoves() {
        return this.numberOfMoves.getNumberOfMoves();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.carName);
        sb.append(" : ");
        sb.append(this.numberOfMoves);

        return sb.toString();
    }

    @Override
    public int compareTo(Car other) {
        return this.numberOfMoves.compare(other.numberOfMoves);
    }
}
