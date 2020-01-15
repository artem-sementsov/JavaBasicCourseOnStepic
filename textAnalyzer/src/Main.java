import ASementsov.java.TextAnalyzer.TextAnalyzer;
import ASementsov.java.TextAnalyzer.TextAnalyzer.Label;

public class Main {
    public static void main(String[] args) {
        String[] spam_container = {"ceil", "kazino"};
        TextAnalyzer spamAnalyzer = new SpamAnalyzer(spam_container);
        TextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();
        TextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(5);
        TextAnalyzer[] textAnalyzers = {spamAnalyzer,negativeTextAnalyzer,tooLongTextAnalyzer};

        String s1 = "wed kazino";
        String s2 = ":( awd ";
        String s3 = "111111111111111";
        System.out.println(checkLabels(textAnalyzers, s3));
    }
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer i : analyzers){
            if (i.processText(text) != Label.OK) {
                return i.processText(text);
            }
        }
        return Label.OK;
    }
}
