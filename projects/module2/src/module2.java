import java.math.*;
import java.util.Arrays;
import java.util.function.ObjDoubleConsumer;

public class module2 {
    public static void main(String[] args) {
        byte [] bytes = {'A', 'B', 'T', 'E', 'Q', 'C'};
        AsciiCharSequence charSequence = new AsciiCharSequence(bytes);

        System.out.println(charSequence.charAt(2));
        System.out.println(charSequence.length());
        System.out.println(charSequence.subSequence(1,3));
        System.out.println(charSequence.toString());

    }


    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }
    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();

        Direction dirX, dirY;

        if (toX >= x)   {dirX = Direction.RIGHT;}
        else            {dirX = Direction.LEFT;}

        if (toY >= y)   {dirY = Direction.UP;}
        else            {dirY = Direction.DOWN;}

        while (robot.getDirection() != dirX)    {robot.turnLeft();}
        while (robot.getX() != toX)             {robot.stepForward();}

        while (robot.getDirection() != dirY)    {robot.turnLeft();}
        while (robot.getY() != toY)             {robot.stepForward();}
    }


    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String role : roles){
            stringBuilder.append(role + ":\n");
            for (int i = 0; i < textLines.length; ++i){
                if (textLines[i].startsWith(role + ":")){
                    stringBuilder.append((i + 1) + ")" + textLines[i].substring(textLines[i].indexOf(":") + 1) + "\n");
                }
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int l1 = a1.length;
        int l2 = a2.length;
        int [] merged = new int [l1+l2];
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (a1[i] < a2[j]) {
                merged[i+j] = a1[i];
                i++;
            }
            else {
                merged[i+j] = a2[j];
                j++;
            }
        }

        while (i < l1) merged[i+j] = a1[i++];
        while (j < l2) merged[i+j] = a2[j++];

        return merged;
    }
    public static BigInteger factorial(int value) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= value; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        return fact;
    }
    public static boolean isPalindrome(String text) {
        String s = text.replaceAll("[^a-zA-Z0-9]", "");
        String t = s.toLowerCase();
        return t.equals(new StringBuilder(t).reverse().toString());
    }
    public static boolean isPowerOfTwo(int value) {
        if (value < 0) value = -value;
        return (value & value-1) == 0 && value > 0;
    }
    public static char charExpression(int a) {
        int slash = (int)'\\';
        return (char)(slash+a);
    }
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << bitIndex-1); // put your implementation here
    }
    public static boolean doubleExpression(double a, double b, double c) {
        double eps = 1e-4;
        return Math.abs(a + b - c) < eps;
    }
    public static int leapYearCount(int year) {
        int res = 0;
        for(int i = 1; i <= year; ++i) {
            if ( (i % 4 == 0) && (i % 100 != 0) || (i % 400 == 0) )
                res++;
        }
        return res;
    }
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        int count = 0;
        if (a) count++;
        if (b) count++;
        if (c) count++;
        if (d) count++;

        return count == 2;
    }
}