import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class OMOSetTest {
    @Test
    void constructorTest() {
        OMOSetView emptySet = new OMOSet();

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        OMOSetView listSet = new OMOSet(list);

        OMOSetView intSet = new OMOSet(new int[]{1, 2, 3});

        OMOSetView omoSet = new OMOSet(listSet, intSet);

        for (int i = 1; i <= 3; i++) {
            Assertions.assertFalse(emptySet.contains(i));

            Assertions.assertTrue(listSet.contains(i));

            Assertions.assertTrue(intSet.contains(i));

            Assertions.assertTrue(omoSet.contains(i));
        }
    }

    @Test
    void addTest() {
        OMOSet set = new OMOSet();

        for (int i = 0; i < 999; i++) {
            set.add(i);
            Assertions.assertTrue(set.contains(i));
        }
    }

    @Test
    void removeTest() {
        OMOSet set = new OMOSet(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        for (int i = 10; i >= 0; i--) {
            set.remove(i);
            Assertions.assertFalse(set.contains(i));
        }
    }

    @Test
    void toArrayTest() {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        OMOSet set = new OMOSet(array);

        for (int i = 0; i < array.length; i++) {
            Assertions.assertEquals(array[i], set.toArray()[i]);
        }
    }

    @Test
    void copyTest() {
        OMOSet original = new OMOSet(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        OMOSet copy = (OMOSet) original.copy();

        original.remove(10);

        Assertions.assertTrue(copy.contains(10));
        Assertions.assertFalse(original.contains(10));
    }
}
