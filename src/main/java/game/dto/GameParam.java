package game.dto;

import java.util.List;

public class GameParam {

    private final List<String> carNames;

    private final int countOfRound;

    public GameParam(final List<String> carNames, final int tryNum) {
        this.carNames = carNames;
        this.countOfRound = tryNum;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getCountOfRound() {
        return countOfRound;
    }
}
