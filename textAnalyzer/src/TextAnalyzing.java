import ASementsov.java.TextAnalyzer.TextAnalyzer;

abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public Label processText(String text) {
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] s) {
        keywords = s;
    }

    @Override
    public Label processText(String text) {
        for (String i : keywords){
            if (text.contains(i)) {
                return Label.SPAM;
            }
        }
        return Label.OK;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    String[] smile = {":(", "=(", ":|"};

    public NegativeTextAnalyzer() {}

    @Override
    public Label processText(String text) {
        for (String i : smile){
            if (text.contains(i)) {
                return Label.NEGATIVE_TEXT;
            }
        }
        return Label.OK;
    }

    @Override
    protected String[] getKeywords() {
        return smile;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int l) {
        maxLength = l;
    }

    @Override
    public Label processText(String text) {
        return text.length() <= maxLength ? Label.OK : Label.TOO_LONG;
    }
}

