package racinggame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racinggame.exception.BusinessException;
import racinggame.utils.Constants;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    private Cars(String input) {
        validate(input);
        addCars(split(input));
    }

    public static Cars of(String input) {
        return new Cars(input);
    }

    public int size() {
        return this.carList.size();
    }

    public void racing(TotalMoves totalMoves) {
        for (int i = 0; i < totalMoves.getTotalMoves(); i++) {
            eachRacing();
        }
    }
    
    public Car get(int index) {
        return this.carList.get(index);
    }

    private String[] split(String input) {
        return input.split(Constants.CAR_NAME_SPLIT_DELIMITER);
    }

    private void addCars(String[] carNames) {
        for (String carName: carNames) {
            this.carList.add(Car.of(carName));
        }
    }

    private void validate(String input) {
        String[] split = split(input);
        Set<String> sets = new HashSet<>(Arrays.asList(split));
        if (sets.size() != split.length) {
            throw new BusinessException("자동차 이름이 중복되었습니다.");
        }
    }


    private void eachRacing() {
        for (Car car : carList) {
            car.moveOrStop();
        }
    }

}
