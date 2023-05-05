package cz.cvut.k36.omo.hw.hw02;


import java.util.ArrayList;
import java.util.List;

// třída reprezentující množinu sudých čísel
public class OMOSetEven implements OMOSetView{
    private OMOSetView omoSet = new OMOSet();
    public OMOSetEven(OMOSetView setA) {
        omoSet = setA;
    }

    @Override
    public boolean contains(int element) {
        return (omoSet.contains(element) && element%2 == 0);
    }

    @Override
    public int[] toArray() {
        OMOSet output = new OMOSet();

        for (int number:
             omoSet.toArray()) {
            if(number%2 == 0){
                output.add(number);
            }
        }

        return output.toArray();
    }

    @Override
    public OMOSetView copy() {
        return new OMOSet(toArray());
    }
}
