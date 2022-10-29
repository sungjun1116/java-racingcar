package game.domain;

import game.domain.movable.MovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarList(final MovableStrategy movableStrategy) {
        for (Car v : this.cars) {
            v.move(movableStrategy);
        }
    }

    public List<Car> findWinners() {
        return findWinners(getMaxPosition());
    }

    private List<Car> findWinners(final Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.hasSamePosition(maxPosition))
                .forEach(winners::add);
        return winners;
    }

    private Position getMaxPosition() {
        return Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
