package game.domain;

import game.domain.movable.MovableStrategy;
import game.dto.GameParam;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Cars cars;

    private TryCount count;

    public RacingGame(GameParam gameParam) {
        this(gameParam.getCarNames(), gameParam.getCountOfRound());
    }

    private RacingGame(final List<String> carNames, final int count) {
        this.cars = new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
        this.count = new TryCount(count);
    }

    public boolean isEnd() {
        return this.count.isEnd();
    }

    public void race(final MovableStrategy movableStrategy) {
        cars.moveCarList(movableStrategy);
        this.count = count.minusCount();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return this.cars.findWinners();
    }
}
