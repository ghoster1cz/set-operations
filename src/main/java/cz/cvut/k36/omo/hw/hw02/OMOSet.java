package cz.cvut.k36.omo.hw.hw02;

import java.util.ArrayList;
import java.util.List;

// třída reprezentující obecnou množinu
public class OMOSet extends OMOSetBase implements OMOSetView{
    private List<Integer> set = new ArrayList<>(){};

    public OMOSet(){}

    public OMOSet(List<Integer> input){
        set.addAll(input);
    }

    public OMOSet(int[] ...inputArrays){
        for (int[] inputArray:
             inputArrays) {
            for (int number:
                 inputArray) {
                add(number);
            }
        }
    }

    public OMOSet(OMOSetView ...inputSets){
        for (OMOSetView inputSet:
             inputSets) {
            for (int number:
                 inputSet.toArray()) {
                add(number);
            }
        }
    }

    @Override
    public void add(int element) {
        if(!contains(element)) {
            set.add(element);
        }
    }

    @Override
    public void remove(int element) {
        set.remove((Object) element);
    }

    @Override
    public boolean contains(int element) {
        return set.contains(element);
    }

    @Override
    public int[] toArray() {
        int[] output = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            output[i] = set.get(i);
        }
        return output;
    }

    @Override
    public OMOSetView copy() {
        return new OMOSet(set);
    }
}


