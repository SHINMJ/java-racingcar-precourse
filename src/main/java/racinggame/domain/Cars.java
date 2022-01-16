package racinggame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        for (int i = Constants.ZERO_INDEX; i < totalMoves.getTotalMoves(); i++) {
            eachRacing();
            System.out.println("");
        }
    }

    public Winners winner() {
        Collections.sort(this.carList);
        return Winners.create(this.carList.subList(Constants.ZERO_INDEX, getLastIndex()));
    }

    private NumberOfMoves firstWinnerNumberOfMoves() {
        return carList.get(Constants.ZERO_INDEX).getNumberOfMoves();
    }

    private int getLastIndex() {
        int lastIndex = Constants.ZERO_INDEX;
        boolean isSame = true;
        while (isSame) {
            lastIndex++;
            isSame = equalsNumberOfMoves(carList.get(lastIndex).getNumberOfMoves());
        }
        return lastIndex;
    }

    private boolean equalsNumberOfMoves(NumberOfMoves numberOfMoves) {
        return firstWinnerNumberOfMoves().equals(numberOfMoves);
    }

    private String[] split(String input) {
        return input.split(Constants.CAR_NAME_SPLIT_DELIMITER);
    }

    private void addCars(String[] carNames) {
        for (String carName : carNames) {
            this.carList.add(Car.of(carName));
        }
    }

    private void validate(String input) {
        String[] split = split(input);
        Set<String> sets = new HashSet<>(Arrays.asList(split));
        if (sets.size() != split.length) {
            throw new BusinessException("[ERROR] 자동차 이름이 중복되었습니다.");
        }
    }

    private void eachRacing() {
        for (Car car : carList) {
            car.moveOrStop();
            System.out.println(car);
        }
    }
}
