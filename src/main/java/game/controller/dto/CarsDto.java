package game.controller.dto;

import game.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsDto {

    private final List<CarDto> carList;

    private CarsDto(final List<CarDto> carList) {
        this.carList = carList;
    }

    public static CarsDto from(final List<Car> cars) {
        return new CarsDto(cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList()));
    }

    public List<CarDto> getCarList() {
        return Collections.unmodifiableList(carList);
    }
}
