package ui;

import logic.ValidationUtils;

import java.util.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        boolean isValidInput = false;
        List<String> carNames = null;
        while (!isValidInput) {
            pleaseEnterCarNames();
            carNames = getPlayerInput();
            isValidInput = ValidationUtils.validateCarNames(carNames);
        }

        return carNames;
    }

    private static void pleaseEnterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    private static List<String> getPlayerInput() {
        String input;
        try {
            input = scanner.next();
        } catch (Exception e) {
            return null;
        }

        return Arrays.asList(input.split(","));
    }

    public static int getMoveCount() {
        pleaseChooseToRestart();
        return getPlayerChoiceInput();
    }

    private static void pleaseChooseToRestart() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static int getPlayerChoiceInput() {
        int input;
        try {
            input = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            return 0;
        }

        return input;
    }

    public static void gameResult() {
        System.out.println("\n실행결과");
    }

    public static void showResult(Map<String, Integer> result) {
        System.out.println("\n");
        gameResult();
        for (Map.Entry<String, Integer> pair : result.entrySet()) {
            String bar = new String(new char[pair.getValue()]).replace("\0", "-");
            System.out.println(pair.getKey() + " : " + bar);
        }
    }

    public static void showWinners(List<String> winners) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String winner : winners) {
            joiner.add(winner);
        }

        System.out.println(joiner + "가 최종 우승했습니다.");
    }
}
