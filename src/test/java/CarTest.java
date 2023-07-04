import gameobject.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarTest {
    private Car car;

    @Test
    void 길이제한을_초과하는_이름() {
        assertThatCode(() -> new Car("amazon"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("5자 이하");

        assertThatCode(() -> new Car(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("1자 이상");
    }

    @BeforeEach
    void setUp() {
        this.car = new Car("구글");
    }

    @Test
    void 평범한_이름() {
        assertThat(car.getName()).isEqualTo("구글");
    }

    @Test
    void 적절하지_않은_이름() {
        assertThatCode(() -> new Car(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("null");
    }

    @Test
    void 위치이동입력값_1_9사이() {
        car.run(3);
        assertThat(car.getPosition()).isEqualTo(0);
        car.run(4);
        assertThat(car.getPosition()).isEqualTo(1);
        assertThatCode(() -> car.run(10))
                .isInstanceOf(RuntimeException.class);
    }
}
