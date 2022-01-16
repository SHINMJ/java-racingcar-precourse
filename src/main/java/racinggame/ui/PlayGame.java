package racinggame.ui;

import nextstep.utils.Console;
import racinggame.domain.Cars;
import racinggame.domain.TotalMoves;
import racinggame.domain.Winners;
import racinggame.exception.BusinessException;

public class PlayGame {

    private Cars cars;
    private TotalMoves totalMoves;

    public PlayGame() {

    }

    public void play() {
        inputCars();
        inputTotalMoves();

        System.out.println("");
        System.out.println("실행 결과");
        racingCars();
        result();
    }

    private void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String readLine = Console.readLine();
            this.cars = Cars.of(readLine);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            inputCars();
        }
    }

    private void inputTotalMoves() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            String readLine = Console.readLine();
            this.totalMoves = TotalMoves.of(readLine);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            inputTotalMoves();
        }
    }

    private void racingCars() {
        cars.racing(this.totalMoves);
    }

    private void result() {
        Winners winners = cars.winner();
        System.out.println(String.format("최종 우승자는 %s 입니다.", winners.toString()));
    }
}
