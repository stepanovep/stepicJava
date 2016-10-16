/**
 * Created by captain_nemo on 30.09.16.
 */
public class Main {
    public static void main(String[] args) {

        try {
            /*int a = 2;
            int b = a / 0;*/
            return;
        } catch (ArithmeticException e) {
            System.out.println("dividing by zero!!");
        }
        finally {
            System.out.println("finally, are u here?");
        }
    }
}
