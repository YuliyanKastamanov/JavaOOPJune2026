package Word;

public class CutTransform implements TextTransform{

    private String cut;
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

        //Вземаме частта, която искаме да премахнем
        String cutPart = text.substring(startIndex, endIndex);
        setCut(cutPart);
        //Премахваме текста, който сме кътнали
        text.delete(startIndex, endIndex);

    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }
}
