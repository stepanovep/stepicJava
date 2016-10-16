public class Main {
    public static void main(String[]args) {
        /*TextAnalyzer a = new Comment().new SpamAnalyzer(new String[] {"spamword1","spamword2"});
        TextAnalyzer b = new Comment().new NegativeTextAnalyzer();
        TextAnalyzer c = new Comment().new TooLongTextAnalyzer(140);
        System.out.println(checkLabels(new TextAnalyzer[]{a, b, c}, "text for testing"));*/

        method1();
        System.out.println(getCallerClassAndMethodName());
        method2();
    }

    private static void method1 () {
        System.out.println(getCallerClassAndMethodName());
    }

    private static void method2 () {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement [] st = new Throwable().getStackTrace();
        if (st.length < 3)
            return null;
        else
            return st[2].getClassName()+'#'+st[2].getMethodName();
    }
}
