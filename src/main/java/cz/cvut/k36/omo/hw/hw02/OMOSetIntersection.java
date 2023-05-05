package cz.cvut.k36.omo.hw.hw02;

// třída reprezentující průnik dvou množin: A průnik B
public class OMOSetIntersection implements OMOSetView{
    private OMOSetView omoSetA, omoSetB;
    public OMOSetIntersection(OMOSetView setA, OMOSetView setB) {
        omoSetA = setA;
        omoSetB = setB;
    }

    @Override
    public boolean contains(int element) {
        return (omoSetA.contains(element) && omoSetB.contains(element));
    }

    @Override
    public int[] toArray() {
        OMOSet output = new OMOSet();
        for (int number:
             omoSetA.toArray()){
            if(omoSetB.contains(number)){
                output.add(number);
            }
        }
        return output.toArray();
    }

    @Override
    public OMOSetView copy() {
        OMOSet output = new OMOSet();
        for (int number:
                omoSetA.toArray()){
            if(omoSetB.contains(number)){
                output.add(number);
            }
        }
        return output;
    }
}
