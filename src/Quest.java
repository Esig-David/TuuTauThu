import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quest {
    private ArrayList<Item> q;

    public Quest(ArrayList<Item> q, String nomFichier) {
        this.q = q;
        lectureTexte(nomFichier, q);
    }

    public ArrayList<Item> getQ() {
        return q;
    }

    public void setQ(ArrayList<Item> q) {
        this.q = q;
    }

    public void lectureTexte(String nomFichier, ArrayList<Item> itemList){
        try{
            Scanner scannerQuestion = new Scanner(new File(nomFichier));
            while (scannerQuestion.hasNext()){
                String question = scannerQuestion.nextLine();
                String reponse = scannerQuestion.nextLine();
                Item item = new Item(question,reponse);
                itemList.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
