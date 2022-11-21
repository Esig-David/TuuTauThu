import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Item> liste = new ArrayList<>();
        Quest quest = new Quest(liste, "Questionnaire1.txt");
        Fenetre f = new Fenetre("Questionnaire", quest);

        f.pack();
        f.setVisible(true);
    }
}
