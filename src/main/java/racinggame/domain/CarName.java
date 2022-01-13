package racinggame.domain;

import java.util.Objects;
import racinggame.exception.BusinessException;
import racinggame.utils.Constants;

public class CarName {
    private static final String CAR_NAME_EXCEPTION_MESSAGE = "1~5자의 이름을 입력해 주세요.";

    private final String carName;

    private CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    public static CarName from(String input) {
        return new CarName(input);
    }

    private void validate(String carName) {
        if (Objects.isNull(carName)) {
            throw new BusinessException(CAR_NAME_EXCEPTION_MESSAGE);
        }
        int carNameLength = carName.length();
        if (carNameLength > Constants.CAR_NAME_MAX_LENGTH
            || carNameLength < Constants.CAR_NAME_NIN_LENGTH) {
            throw new BusinessException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return carName;
    }
}
