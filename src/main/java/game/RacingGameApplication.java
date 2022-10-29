package game;

import game.domain.RacingGame;
import game.domain.movable.RandomNumberMovableStrategy;
import game.dto.CarsDto;
import game.view.InputView;
import game.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.getGameParam());

        ResultView.printOutputStart();
        while (!racingGame.isEnd()) {
            racingGame.race(new RandomNumberMovableStrategy());
            ResultView.printCars(CarsDto.from(racingGame.getCars()));
        }
        ResultView.printWinners(CarsDto.from(racingGame.getWinners()));
    }
}
