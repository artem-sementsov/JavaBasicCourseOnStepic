import ASementsov.java.timing.Timer;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        long time = timer.measureTime(Main::bigDecimalPower);
        System.out.println(time);
    }

    private static void bigDecimalPower() {
        new BigDecimal("1234567").pow(100000);
    }
}