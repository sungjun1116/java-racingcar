package game.domain;

import utils.StringUtils;

public class CarName {

    private static final int CAR_NAME_LIMIT_LENGTH = 5;
    private final String name;

    public CarName(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private static void validateCarName(final String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("자동차 이름은 null 혹은 공백일 수 없습니다.");
        }
        if (name.length() > CAR_NAME_LIMIT_LENGTH ) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;

        CarName carName = (CarName) o;

        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
