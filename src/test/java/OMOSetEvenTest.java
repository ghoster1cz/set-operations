import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetEven;
import cz.cvut.k36.omo.hw.hw02.OMOSetView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OMOSetEvenTest {
    @Test
    void constructorTest() {
        OMOSetView omoSet = new OMOSet(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        OMOSetView omoEven = new OMOSetEven(omoSet);

        for (int i = 0; i <= 10; i++) {
            if(i%2 == 0) {
                Assertions.assertTrue(omoEven.contains(i));
            } else {
                Assertions.assertFalse(omoEven.contains(i));
            }
        }
    }

    @Test
    void copyTest() {
        OMOSetView omoSet = new OMOSet(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        OMOSetView omoEvenOriginal = new OMOSetEven(omoSet);
        OMOSet omoEvenCopy = (OMOSet) omoEvenOriginal.copy();

        omoEvenCopy.add(12);

        Assertions.assertFalse(omoEvenOriginal.contains(12));
        Assertions.assertTrue(omoEvenCopy.contains(12));
    }

    @Test
    void originalSetChangeTest() {
        OMOSet omoSet = new OMOSet(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        OMOSetView omoEven = new OMOSetEven(omoSet);

        Assertions.assertTrue(omoEven.contains(8));

        omoSet.remove(8);

        Assertions.assertFalse(omoEven.contains(8));
    }
}
