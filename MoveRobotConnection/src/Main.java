public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        try {
            Robot.moveRobot(robot, 5, 5);
        } catch (RuntimeException e) {
            System.out.println(e);
        }

    }
}
