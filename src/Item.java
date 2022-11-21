public class Item {
    private String question;
    private String réponse;

    public Item(String question, String réponse) {
        this.question = question;
        this.réponse = réponse;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRéponse() {
        return réponse;
    }

    public void setRéponse(String réponse) {
        this.réponse = réponse;
    }

    @Override
    public String toString() {
        return "Item{" +
                "question='" + question + '\'' +
                ", réponse='" + réponse + '\'' +
                '}';
    }
}
