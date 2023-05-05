package cz.cvut.k36.omo.hw.hw02;

// třída reprezentující sjednocení dvou množin: A sjednoceno B
public class OMOSetUnion implements OMOSetView{
    private OMOSetView omoSetA, omoSetB;
    public OMOSetUnion(OMOSetView setA, OMOSetView setB) {
        omoSetA = setA;
        omoSetB = setB;
    }

    @Override
    public boolean contains(int element) {
        return (omoSetA.contains(element) || omoSetB.contains(element));
    }

    @Override
    public int[] toArray() {
        return new OMOSet(omoSetA, omoSetB).toArray();
    }

    @Override
    public OMOSetView copy() {
        return new OMOSet(omoSetA, omoSetB);
    }
}
