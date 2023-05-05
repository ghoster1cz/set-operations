package cz.cvut.k36.omo.hw.hw02;

// třída reprezentující A\B: doplněk množiny B vzhledem k množině A:  A\B = { x | x∈A ∧ x∉B }
public class OMOSetComplement implements OMOSetView{
    private OMOSetView omoSetA, omoSetB;
    OMOSetComplement(OMOSetView setA, OMOSetView setB) {
        omoSetA = setA;
        omoSetB = setB;
    }

    @Override
    public boolean contains(int element) {
        return (omoSetA.contains(element) && !omoSetB.contains(element));
    }

    @Override
    public int[] toArray() {
        OMOSet output = new OMOSet();
        for (int number:
                omoSetA.toArray()){
            if(!omoSetB.contains(number)){
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
            if(!omoSetB.contains(number)){
                output.add(number);
            }
        }
        return output;
    }
}
