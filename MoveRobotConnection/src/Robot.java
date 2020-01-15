public class Robot implements RobotConnectionManager, RobotConnection {
    private int x, y;

    Robot() {
        x = 0;
        y = 0;
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int trying = 0;
        RobotConnection robotConnection = null;
        while (trying < 3) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
                trying++;
            } finally {
                try {
                    robotConnection.close();
                }
                catch (RuntimeException e) {

                }
            }
        }
        if (trying == 3) {
            throw new RobotConnectionException("");
        }
    }

    @Override
    public RobotConnection getConnection() {
        return new Robot();
    }

    @Override
    public void moveRobotTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void close() {
        try {
            int b = 1/0;
        } catch (RuntimeException e) {
            throw new RobotConnectionException(e.toString());
        }
    }
}
