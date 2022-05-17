package HW1;

public class QuadEquation {
    private final int a;
    private final int b;
    private final int c;

    public QuadEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] findResults() {
        double[] results = new double[2];
        results[0] = (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
        results[1] = (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);

        return results;
    }


    @Override
    public String toString() {
        double[] results = findResults();
        return "The possible results are " + results[0] + " and " + results[1];
    }
}
