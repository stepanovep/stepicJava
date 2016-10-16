/**
 * Created by captain_nemo on 30.09.16.
 */
public class Main {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean status = false;
        for (int i = 0;;) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                status = true;
                i = 3;
                return;
            } catch (RobotConnectionException RCE) {
                if (status == false) i++;
                if (i == 2) throw RCE;
            } catch (Throwable t) {
                throw t;
            }
        }
    }
}
