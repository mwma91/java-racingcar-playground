import gameobject.Cars;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarsTest {
    @Test
    void 문자열에서_자동차_생성() {
        Cars cars = new Cars("구글,애플,아마존");
        assertThat(cars.getCarByName("구글")).isNotNull();
        assertThat(cars.getCarByName("애플")).isNotNull();
        assertThat(cars.getCarByName("아마존")).isNotNull();
        assertThat(cars.getCarByName("페이스북")).isNull();
    }

    @Test
    void 잘못된_이름() {
        assertThatCode(() -> new Cars(""))
                .isInstanceOf(RuntimeException.class);
        assertThatCode(() -> new Cars(null))
                        .isInstanceOf(RuntimeException.class);
        assertThatCode(() -> new Cars("구글,,아마존"))
                        .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 전진() {

    }
}
