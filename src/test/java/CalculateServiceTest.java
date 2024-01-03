import de.bit.service.CalculateService;
import de.bit.service.LinearCalculateService;
import de.bit.service.VectorCalculateService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTest {
    CalculateService calculateService;

    @Test
    void linearCalculateTest() {
        calculateService = new LinearCalculateService();
        assertEquals(2, calculateService.calculate(1, 1));
    }

    @Test
    void vectorCalculateTest(){
        calculateService = new VectorCalculateService();
        assertEquals(5,calculateService.calculate(4,3));
    }

}
