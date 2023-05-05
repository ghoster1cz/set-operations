import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetIntersection;
import cz.cvut.k36.omo.hw.hw02.OMOSetUnion;
import cz.cvut.k36.omo.hw.hw02.OMOSetView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeepCopyTest {

    @Test
    void deepCopyTest() {
        OMOSet omoSetA = new OMOSet(new int[]{1, 2, 3, 4, 5});
        OMOSet omoSetB = new OMOSet(new int[]{4, 5, 6, 7, 8});
        OMOSet omoSetC = new OMOSet(new int[]{8, 9, 10, 11, 12});

        OMOSetView omoIntersection = new OMOSetIntersection(omoSetA, omoSetB);
        OMOSetView omoUnion = new OMOSetUnion(omoIntersection, omoSetC);

        Assertions.assertTrue(omoIntersection.contains(4));
        Assertions.assertTrue(omoIntersection.contains(5));

        Assertions.assertTrue(omoUnion.contains(4));
        Assertions.assertTrue(omoUnion.contains(5));
        Assertions.assertTrue(omoUnion.contains(10));

        omoSetA.remove(4);
        Assertions.assertFalse(omoIntersection.contains(4));
        Assertions.assertFalse(omoUnion.contains(4));

        int[] expArray = new int[]{5, 8, 9, 10, 11, 12};
        for (int i = 0; i < expArray.length; i++) {
            Assertions.assertEquals(expArray[i], omoUnion.toArray()[i]);
        }
    }
}
