import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        if (isSingleDigit(input)) {
            return Integer.parseInt(input);
        }

        if (isShort(input)) {
            String[] numbers = getNumbers(input, DEFAULT_SEPARATOR);
            return getSum(numbers);
        }

        Matcher matcher = hasCustomSeparator(input);
        if (!matcher.matches()) {
            String[] numbers = getNumbers(input, DEFAULT_SEPARATOR);
            return getSum(numbers);
        }

        String customSeparator = getCustomSeparator(matcher);
        String separators = getSeparators(customSeparator);
        String[] numbers = getNumbers(input.substring(4), separators);

        return getSum(numbers);
    }

    private static String[] getNumbers(String input, String separators) {
        return input.split(separators);
    }

    private static String getSeparators(String customSeparator) {
        return "[" + customSeparator + ":" + "," + "]";
    }

    private static String getCustomSeparator(Matcher matcher) {
        return String.valueOf(matcher.group().charAt(2));
    }

    private static boolean isBlank(String input) {
        return (input == null) || input.isEmpty();
    }

    private static boolean isSingleDigit(String input) {
        return input.length() == 1;
    }

    private static boolean isShort(String input) {
        return input.length() < 5;
    }

    private static Matcher hasCustomSeparator(String input) {
        String regex = "^//[^:,a-zA-Z0-9]\\n$";
        Pattern pattern = Pattern.compile(regex);

        String stringsAtStart = input.substring(0, 4);
        return pattern.matcher(stringsAtStart);
    }

    private static int getSum(String[] numbers) {
        Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(number -> number < 0)
                .findFirst()
                .ifPresent(number -> {
                    throw new RuntimeException();
                });

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
