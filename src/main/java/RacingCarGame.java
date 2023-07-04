import gameobject.Cars;
import ui.InputView;

import java.util.List;
import java.util.Map;

public class RacingCarGame {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.getCarNames());
        int moveCount = InputView.getMoveCount();

        for (int i = 0; i < moveCount; i++) {
            Map<String, Integer> result = cars.run();
            InputView.showResult(result);
        }

        List<String> winners = cars.getWinners();
        InputView.showWinners(winners);
    }
}
