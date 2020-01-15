package ASementsov.java;

public class Main {
    public static void main(String[] args) {
//        System.out.println(getCallerClassAndMethodName());
//        anotherMethod();

        try {
//            System.exit(0);
            int i = 1/0;
        } catch (Exception e) {
            int i = 1/0;
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }

    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] a = new Exception().getStackTrace();
        if (a.length < 3){
            return null;
        }
        int i = 2;
        return a[i].getClassName() + '#' + a[i].getMethodName();
    }
}
