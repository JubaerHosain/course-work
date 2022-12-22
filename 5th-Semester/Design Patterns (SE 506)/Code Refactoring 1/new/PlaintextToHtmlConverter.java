import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    String source;
    List<String> result;
    List<String> convertedLine;

    public String toHtml(String filename) throws Exception {
        String text = read(filename);
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    private String basicHtmlEncode(String source) {
        this.source = source;
        result = new ArrayList<>();
        convertedLine = new ArrayList<>();

        for(int i = 0; i < source.length(); i++) {
            String characterToConvert = stashNextCharacterAndAdvanceThePointer(i);
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
                    pushACharacterToTheOutput(characterToConvert);
            }
        }
        addANewLine();
        String finalResult = String.join("<br />", result);
        return finalResult;
    }

    //pick the character from source string and increment the pointer
    private String stashNextCharacterAndAdvanceThePointer(int i) {
        return String.valueOf(source.charAt(i));
    }

    // stringify convertedLine array and push into result reset convertedLine
    private void addANewLine() {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private void pushACharacterToTheOutput(String characterToConvert) {
        convertedLine.add(characterToConvert);
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        PlaintextToHtmlConverter converter = new PlaintextToHtmlConverter();
        System.out.println(converter.toHtml("sample.txt"));
    }
}