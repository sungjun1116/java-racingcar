package game.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {

    @Test
    void 자동차_경주_이동_가능() {
        Cars cars = new Cars(List.of(new Car(0, "a"), new Car(0, "b"), new Car(0, "c")));

        cars.moveCarList(() -> true);

        for (Car car : cars.getCars()) {
            Assertions.assertThat(car.getPosition()).isEqualTo(new Position(1));
        }
    }

    @Test
    void 자동차_경주_이동_불가능() {
        Cars cars = new Cars(List.of(new Car(0, "a"), new Car(0, "b"), new Car(0, "c")));

        cars.moveCarList(() -> false);

        for (Car car : cars.getCars()) {
            Assertions.assertThat(car.getPosition()).isEqualTo(new Position(0));
        }
    }

    @Test
    void 우승자_구하기() {
        Car a = new Car(1, "a");
        Car b = new Car(1, "b");
        Car c = new Car(0, "c");
        Cars cars = new Cars(List.of(a, b, c));

        Assertions.assertThat(cars.findWinners()).containsExactly(a, b);
    }
}
