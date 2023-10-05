package generic;

public class TextBugInput extends GenericHandler<String>{
    @Override
    protected String handleInput(String input) {
        return input.replace("w zadaniu jest blad", "w zadaniu nie ma bledu");
    }
}
