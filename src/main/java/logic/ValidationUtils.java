package logic;

import java.util.List;

public class ValidationUtils {
    public static boolean validateCarNames(List<String> carNames) {
        return (carNames != null) && isNotEmpty(carNames) && isValidNames(carNames) && !hasDuplicates(carNames);
    }

    public static boolean isNotEmpty(List<String> carNames) {
        return carNames.size() > 0;
    }

    public static boolean isValidNames(List<String> carNames) {
        return carNames.stream()
                .noneMatch(String::isEmpty);
    }

    public static boolean hasDuplicates(List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }
}
