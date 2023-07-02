package gameobject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;

    public Cars(String input) {
        if (isNullOrEmpty(input)) {
            throw new RuntimeException();
        }
        String[] names = input.split(",");
        if (names.length < 1) {
            throw new RuntimeException();
        }

        this.cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Car getCarByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
