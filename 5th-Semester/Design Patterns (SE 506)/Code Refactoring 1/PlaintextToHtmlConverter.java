import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    String source;
    int i;
    List<String> result;
    List<String> convertedLine;
    String characterToConvert;

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }

    private String basicHtmlEncode(String source) {

        result = new ArrayList<>();
        convertedLine = new ArrayList<>();

        convert(source);

        addANewLine();
        String finalResult = String.join("<br />", result);
        return finalResult;
    }


    public void convert(String source)                                 //Method extraction for long method smell
    {
        this.source = source;
        i = 0;
        while (i <= this.source.length()) {
            characterToConvert = stashNextCharacterAndAdvanceThePointer();
            switch (characterToConvert) {
                case "<":
                    convertedLine.add("&lt;");
                    break;
                case ">":
                    convertedLine.add("&gt;");
                    break;
                case "&":
                    convertedLine.add("&amp;");
                    break;
                case "\n":
                    addANewLine();
                    break;
                default:
                    pushACharacterToTheOutput();
            }
            i =i+ 1;
        }
    }

    private String stashNextCharacterAndAdvanceThePointer() {
        char c = source.charAt(i);
        return String.valueOf(c);
    }

    private void addANewLine() {
        pushConvertedLineToResult();         //For removing commenting smell
        resetConvertedLine();                //For removing commenting smell
    }

    private void pushConvertedLineToResult() {
        result.add(String.join("", convertedLine));
    }

    private void resetConvertedLine() {
        convertedLine = new ArrayList<>();
    }

    private void pushACharacterToTheOutput() {
        convertedLine.add(characterToConvert);
    }
}
