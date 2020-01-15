import java.security.DigestException;
import java.util.ArrayList;
import static java.lang.System.*;

public class printTextPerRole {
    public static void main(String[] args) {
//        String[] roles = new String[4];
//        roles[0] = "Городничий";
//        roles[1] = "Аммос Федорович";
//        roles[2] = "Артемий Филиппович";
//        roles[3] = "Лука Лукич";
//
//        String[] textLines = new String[7];
//        textLines[0] = "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.";
//        textLines[1] = "Аммос Федорович: Как ревизор?";
//        textLines[2] = "Артемий Филиппович: Как ревизор?";
//        textLines[3] = "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.";
//        textLines[4] = "Аммос Федорович: Вот те на!";
//        textLines[5] = "Артемий Филиппович: Вот не было заботы, так подай!";
//        textLines[6] = "Лука Лукич: Господи боже! еще и с секретным предписаньем!";
//        System.out.println(printTextPerRole(roles, textLines));
        Robot robot = new Robot();
        moveRobot(robot, 3, 0);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
    }
    static String printTextPerRole(String[] roles, String[] textLines) {
        ArrayList res = new ArrayList();
        for (int i = 0; i < roles.length; i++){
            res.add(roles[i] + ":" + "\n");
            for (int j = 0; j < textLines.length; j++){
                if (textLines[j].toString().startsWith(roles[i] + ":")){
                    res.add(String.valueOf(j+1) + ")" + textLines[j].replaceFirst(roles[i] + ":", "") + "\n");
                }
            }
            res.add("\n");
        }
        StringBuilder res_str = new StringBuilder();
        for (int i = 0; i < res.size(); i++){
            res_str = res_str.append(res.get(i).toString());
        }
        String str2 = res_str.toString();
        return str2;
    }
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    public static class Robot {
        private int x, y;
        private Direction Dir = Direction.UP;

        public final static void pr ( int i){
            final int a = 0;
        }

        public Robot() {
            x = 0;
            y = 0;
            Dir = Direction.UP;
        }

        public Direction getDirection() {
            return this.Dir;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void turnLeft() {
            switch (Dir) {
                case UP:
                    Dir = Direction.LEFT;
                    break;
                case LEFT:
                    Dir = Direction.DOWN;
                    break;
                case DOWN:
                    Dir = Direction.RIGHT;
                    break;
                case RIGHT:
                    Dir = Direction.UP;
                    break;
            }
        }

        public void turnRight() {
            switch (Dir) {
                case UP:
                    Dir = Direction.RIGHT;
                    break;
                case LEFT:
                    Dir = Direction.UP;
                    break;
                case DOWN:
                    Dir = Direction.LEFT;
                    break;
                case RIGHT:
                    Dir = Direction.DOWN;
                    break;
            }
        }

        public void stepForward() {
            switch (Dir) {
                case UP:
                    y++;
                    break;
                case LEFT:
                    x--;
                    break;
                case DOWN:
                    y--;
                    break;
                case RIGHT:
                    x++;
                    break;
            }
        }
    }
    static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() < toX){
            while (robot.getDirection() != Direction.RIGHT){
                robot.turnLeft();
            }
            while (robot.getX() != toX){
                robot.stepForward();
            }
        } else {
            while (robot.getDirection() != Direction.LEFT){
                robot.turnLeft();
            }
            while (robot.getX() != toX){
                robot.stepForward();
            }
        }
        if (robot.getY() < toY){
            while (robot.getDirection() != Direction.UP){
                robot.turnLeft();
            }
            while (robot.getY() != toY){
                robot.stepForward();
            }
        } else {
            while (robot.getDirection() != Direction.DOWN){
                robot.turnLeft();
            }
            while (robot.getY() != toY){
                robot.stepForward();
            }
        }
    }
}

