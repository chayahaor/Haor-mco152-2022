package HW1;

public class QuadEquation {
    int a;
    int b;
    int c;

    public double[] findResults() {
        double[] results = new double[2];
        results[0] = -b + Math.sqrt(b * b - (4 * a * c));
        results[1] = -b - Math.sqrt(b * b - (4 * a * c));

        return results;
    }


    public QuadEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "The possible results are " + findResults()[0] + " and " + findResults()[1]                    ;
    }
}
