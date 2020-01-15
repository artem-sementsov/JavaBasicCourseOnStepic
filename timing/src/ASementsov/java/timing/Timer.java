package ASementsov.java.timing;

public class Timer {
    public long measureTime(Runnable runnable){
        long startTime = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - startTime;
    }
}
