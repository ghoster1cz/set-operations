package cz.cvut.k36.omo.hw.hw02;

public class Main {
    public static void main(String[] args) {
        OMOSetView A = new OMOSet(new int[]{1, 2, 3});
        OMOSetView B = new OMOSet(new int[]{2, 3, 4});

        OMOSetView union = new OMOSetUnion(A, B);
        OMOSetView intersection = new OMOSetIntersection(A, B);
        OMOSetView even = new OMOSetEven(union);

        OMOSetView complementA = new OMOSetComplement(A, B);
        OMOSetView complementB = new OMOSetComplement(B, A);

        OMOSetView deepUnion = new OMOSetUnion(complementA, complementB);
        OMOSetView deepIntersection = new OMOSetIntersection(complementA, complementB);
        OMOSetView deepEven = new OMOSetEven(deepUnion);
        OMOSetView deepComplement = new OMOSetComplement(union, intersection);
        for (int number:
                union.toArray()) {
            System.out.println(number);
        }
        System.out.println("----------------");
        for (int number:
                intersection.toArray()) {
            System.out.println(number);
        }
        System.out.println("----------------");
        for (int number:
                deepComplement.toArray()) {
            System.out.println(number);
        }
        System.out.println("----------------");
    }
}
