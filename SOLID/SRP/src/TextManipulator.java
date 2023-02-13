public class TextManipulator {
    //reference : https://www.baeldung.com/java-single-responsibility-principle
    private String text;

    public TextManipulator(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void appendText(String newText) {
        text = text.concat(newText);
    }

    public String findWordAndReplace(String word, String replacementWord) {
        if (text.contains(word)) {
            text = text.replace(word, replacementWord);
        }
        return text;
    }

    public String findWordAndDelete(String word) {
        if (text.contains(word)) {
            text = text.replace(word, "");
        }
        return text;
    }

    /**
     * 다른 메소드는 문자를 조작하기 위한 단일 책임 원칙을 잘 지키고 있지만,
     * printText는 문자 조작과 다른 문자 출력에 대한 것이므로, 단일 책임 원칙을 위배한다.
     * SRP를 위해 문자 출력은 다른 클래스에서 관리해야 적절하다.
     */
    public void printText() {
        System.out.println(getText());
    }

}
