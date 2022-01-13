package racinggame.domain;

public class Car {
    private CarName carName;
    private Moves moves;

    private Car(String carName) {
        this.carName = CarName.from(carName);
        this.moves = Moves.create();
    }

    public static Car of(String carName) {
        return new Car(carName);
    }

    public void addMoves(){
        this.moves.addMoves();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.carName);
        sb.append(" : ");
        sb.append(this.moves);

        return sb.toString();
    }
}
