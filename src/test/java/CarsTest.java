import gameobject.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setup() {
        this.cars = new Cars(Arrays.asList("구글", "애플", "아마존"));
    }

    @Test
    void 문자열에서_자동차_생성() {
        assertThat(cars.getCarByName("구글")).isNotNull();
        assertThat(cars.getCarByName("애플")).isNotNull();
        assertThat(cars.getCarByName("아마존")).isNotNull();
        assertThat(cars.getCarByName("페이스북")).isNull();
    }

    @Test
    void 잘못된_이름() {
        assertThatCode(() -> new Cars(Arrays.asList("", "애플", "아마존")))
                .isInstanceOf(RuntimeException.class);
        assertThatCode(() -> new Cars(Arrays.asList(null, "애플", "아마존")))
                .isInstanceOf(RuntimeException.class);
        assertThatCode(() -> new Cars(Arrays.asList("구글", "", "아마존")))
                .isInstanceOf(RuntimeException.class);
    }
}
