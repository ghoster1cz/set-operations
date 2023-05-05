import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetUnion;
import cz.cvut.k36.omo.hw.hw02.OMOSetView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OMOSetUnionTest {
    @Test
    void constructorTest() {
        OMOSetView omoSetA = new OMOSet(new int[]{1, 2, 3, 4, 5});
        OMOSetView omoSetB = new OMOSet(new int[]{6, 7, 8, 9, 10});

        OMOSetUnion omoUnion = new OMOSetUnion(omoSetA, omoSetB);

        for (int i = 0; i < omoSetA.toArray().length; i++) {
            Assertions.assertTrue(omoUnion.contains(omoSetA.toArray()[i]));
            Assertions.assertTrue(omoUnion.contains(omoSetB.toArray()[i]));
        }
    }

    @Test
    void toArrayTest() {
        int[] arrayA = new int[]{1, 2, 3, 4, 5};
        int[] arrayB = new int[]{6, 7, 8, 9, 10};

        OMOSetView omoSetA = new OMOSet(arrayA);
        OMOSetView omoSetB = new OMOSet(arrayB);

        OMOSetUnion omoUnion = new OMOSetUnion(omoSetA, omoSetB);

        int[] unionArray = omoUnion.toArray();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < arrayA.length; j++) {
                if(i == 0) {
                    Assertions.assertEquals(arrayA[j], unionArray[j]);
                } else {
                    Assertions.assertEquals(arrayB[j], unionArray[j+arrayA.length]);
                }
            }
        }
    }

    @Test
    void omoSetChangeTest(){
        OMOSet omoSetA = new OMOSet(new int[]{1, 2, 3, 4, 5});
        OMOSet omoSetB = new OMOSet(new int[]{6, 7, 8, 9, 10});

        OMOSetUnion omoUnion = new OMOSetUnion(omoSetA, omoSetB);

        Assertions.assertTrue(omoUnion.contains(8));

        omoSetB.remove(8);

        Assertions.assertFalse(omoUnion.contains(8));
    }
}
