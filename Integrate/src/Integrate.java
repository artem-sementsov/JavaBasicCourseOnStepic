public class Integrate {
    public static void main(String[] args) {

    }
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double s = 0;
        for (int i = 0; i < 1000000 * (b - a); i++){
            s += f.applyAsDouble(a + i * 0,000001);
        }
        return s;
    }
}

