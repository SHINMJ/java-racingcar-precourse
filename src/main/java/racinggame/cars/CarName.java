package racinggame.cars;

import static racinggame.cars.RacingUtils.*;

public class CarName {
	private String carName;

	public CarName(String carName) {
		validCarName(carName);
		this.carName = carName;
	}

	public String getCarName() {
		return this.carName;
	}
}
