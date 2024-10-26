package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @BeforeEach
    void setUp() {
        Cars.cars = new HashMap<>();
    }

    @Test
    void 자동차_등록_실페(){
        List<String> carNames = Arrays.asList("CarA", "CarB", "CarCDE");

        assertThrows(IllegalArgumentException.class, () -> {
            Cars.register(carNames);
        });
    }

    @Test
    void 자동차_등록_성공(){
        List<String> carNames = Arrays.asList("CarA", "CarB", "CarC");

        assertDoesNotThrow(()->{
            Cars.register(carNames);
        });
    }

    @Test
    void 자동차_전진_성공(){
        List<String> carNames = Arrays.asList("CarA", "CarB");
        Cars.register(carNames);

        Map<String, String> movedCars = Cars.moveForward();

        assertEquals(2, movedCars.size());
        for (String car : carNames) {
            assertTrue(movedCars.get(car).equals("") || movedCars.get(car).contains("-"));
        }
    }
}
