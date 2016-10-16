public class Main {

    public static void main(String[] args) {
        Comment com = new Comment();
        TextAnalyzer a = com.new SpamAnalyzer(new String[] {"spamword1", "spamword2"});
        TextAnalyzer b = com.new NegativeTextAnalyzer();
        TextAnalyzer c = com.new TooLongTextAnalyzer(140);

        System.out.println(checkLabels(new TextAnalyzer[]{a, b, c}, "text for testing"));
    }


    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer textAnalyzer : analyzers) {
            if (textAnalyzer.processText(text) != Label.OK) {
                if (textAnalyzer instanceof Comment.KeywordAnalyzer) {
                    return ((Comment.KeywordAnalyzer) textAnalyzer).getLabel();
                } else
                    return Label.TOO_LONG;
            }
        }

        return Label.OK;
    }

    public static class Comment {

        abstract class KeywordAnalyzer implements TextAnalyzer {
            protected abstract String[] getKeywords();

            protected abstract Label getLabel();

            @Override
            public Label processText(String text) {
                for (String keyword : getKeywords())
                    if (text.contains(keyword))
                        return getLabel();

                return Label.OK;
            }
        }


        public class SpamAnalyzer extends KeywordAnalyzer {
            private String[] keywords;

            public SpamAnalyzer(String[] keywords) {
                this.keywords = keywords;
            }

            @Override
            protected String[] getKeywords() {
                return this.keywords;
            }

            @Override
            protected Label getLabel() {
                return Label.SPAM;
            }

        }

        /**
         * Created by captain_nemo on 29.09.16.
         */
        public class NegativeTextAnalyzer extends KeywordAnalyzer {

            @Override
            protected String[] getKeywords() {
                return new String[]{":(", "=(", ":|"};
            }

            @Override
            protected Label getLabel() {
                return Label.NEGATIVE_TEXT;
            }
        }


        /**
         * Created by captain_nemo on 29.09.16.
         */
        public class TooLongTextAnalyzer implements TextAnalyzer {

            private int maxLength;

            public TooLongTextAnalyzer(int maxLength) {
                this.maxLength = maxLength;
            }

            @Override
            public Label processText(String text) {
                if (text.length() > maxLength)
                    return Label.TOO_LONG;
                else
                    return Label.OK;
            }
        }
    }
}