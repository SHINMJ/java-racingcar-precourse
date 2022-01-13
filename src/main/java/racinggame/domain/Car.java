package racinggame.domain;

public class Car {
    private CarName carName;
    private NumberOfMoves numberOfMoves;

    private Car(String carName) {
        this.carName = CarName.from(carName);
        this.numberOfMoves = NumberOfMoves.create();
    }

    public static Car of(String carName) {
        return new Car(carName);
    }

    public void addMoves(){
        this.numberOfMoves.addMoves();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.carName);
        sb.append(" : ");
        sb.append(this.numberOfMoves);

        return sb.toString();
    }
}
