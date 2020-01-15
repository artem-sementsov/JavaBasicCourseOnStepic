import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.println(integrate(new DoubleUnaryOperator() {
            @Override
            public double applyAsDouble(double v) {
                return 1;
            }
        }, 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double s = 0;
        for (int i = 0; i < 1000000 * (b - a); i++){
            s += f.applyAsDouble(a + i * 0.000001) * 0.000001;
        }
        return s;
    }
}
