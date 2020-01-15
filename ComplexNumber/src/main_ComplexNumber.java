public class main_ComplexNumber {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);

        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    public static final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(this.re + this.re);
        }

        @Override
        public boolean equals(Object var1) {
            return var1 instanceof ComplexNumber && ((ComplexNumber) var1).re == this.re && ((ComplexNumber) var1).im == this.im;
        }
    }
}
