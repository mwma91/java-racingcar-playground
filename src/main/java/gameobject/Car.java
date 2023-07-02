package gameobject;

import lombok.Getter;

@Getter
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        isNotNull(name);
        isValidLength(name);
        this.name = name;
    }

    private void isNotNull(String name) {
        if (name == null) {
            throw new RuntimeException("차 이름은 null일 수 없습니다.");
        }
    }

    private static void isValidLength(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new RuntimeException("차 이름은 1자 이상, 5자 이하여야 합니다.");
        }
    }

    public void run(int randomNumber) {
        isValidInput(randomNumber);
        if (isValidSize(randomNumber)) {
            ++position;
        }
    }

    private static void isValidInput(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new RuntimeException();
        }
    }

    private static boolean isValidSize(int randomNumber) {
        return randomNumber >= 4;
    }
}
