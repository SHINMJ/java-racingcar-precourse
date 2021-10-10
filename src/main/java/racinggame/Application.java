package racinggame;

import nextstep.utils.Console;
import racinggame.common.Messages;
import racinggame.game.Game;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        System.out.println(Messages.GAME_START.getValues());
        Game game = getInputCarNames();
        System.out.println(Messages.GAME_COUNT.getValues());
        game = getInputCount(game);
        System.out.println("");
        game.playGame();
    }

    public static Game getInputCarNames() {
        Game game;
        String input = Console.readLine();
        try {
            game = new Game(input);
        }catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return getInputCarNames();
        }
        return game;
    }

    public static Game getInputCount(Game game) {
        String input = Console.readLine();
        try {
            game.setCount(input);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInputCarNames();
        }
        return game;
    }

}
