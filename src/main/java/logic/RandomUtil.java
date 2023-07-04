package logic;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random(System.currentTimeMillis());

    public static int getPower() {
        return random.nextInt(10);
    }
}
