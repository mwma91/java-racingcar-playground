package gameobject;

import logic.RandomUtil;
import logic.ValidationUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private int moveCount;
    List<Car> cars;

    public Cars(List<String> carNames) {
        if (!ValidationUtils.validateCarNames(carNames)) {
            throw new IllegalArgumentException();
        }

        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Car getCarByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Map<String, Integer> run() {
        for (Car car : cars) {
            car.run(RandomUtil.getPower());
        }
        ++this.moveCount;
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public List<String> getWinners() {
        int winnerMoveCount = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == winnerMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
