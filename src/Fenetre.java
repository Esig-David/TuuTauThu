import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Fenetre extends JFrame implements ActionListener {
    JTextArea items;
    JTextField reponse;
    JLabel questions;
    JButton question, afficher, quitter, suivant;
    JScrollPane scroll;
    ArrayList<Item> questionnaire;
    Random rand = new Random();

    int cptAfficher = 0;

    Fenetre(String aTitle, Quest questionnaire) {
        this.questionnaire = questionnaire.getQ();
        JPanel panel = new JPanel(new GridLayout(0, 3));
        setTitle(aTitle);
        question = new JButton("Questionnaire");
        question.addActionListener(this);
        afficher = new JButton("Afficher");
        afficher.addActionListener(this);
        suivant = new JButton("Suivant");
        suivant.addActionListener(this);
        suivant.setVisible(false);
        quitter = new JButton("Quitter");
        quitter.addActionListener(this);

        panel.add(question, "West");
        panel.add(afficher, "Center");

        panel.add(quitter, "East");
        add(panel, "North");
        items = new JTextArea(10, 50);
        for (Item item : questionnaire.getQ()) {
            items.append("Question: " + item.getQuestion() + "\n" + "Réponse: " + item.getRéponse() + "\n" + "\n");
        }
        add(items);
        items.setVisible(false);
        scroll = new JScrollPane(items);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
        scroll.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(afficher)) {
            cptAfficher++;
            if (cptAfficher % 2 == 0) {
                items.setVisible(false);
                afficher.setText("Afficher");
                scroll.setVisible(false);
            } else {
                items.setVisible(true);
                afficher.setText("Cacher");
                scroll.setVisible(true);

            }
            this.pack();

        } else if (actionEvent.getSource().equals(quitter)) {
            this.setVisible(false);
            FileChooser fc = new FileChooser();
            fc.pack();
            fc.setVisible(true);
            fc.setLocationRelativeTo(null);
        }else if (actionEvent.getSource().equals(question)) {
            afficher.setVisible(false);
            this.setSize(500,300);
            int nombre_hasard = rand.nextInt(questionnaire.size());
            setLayout(new FlowLayout());
            add(suivant);
            suivant.setVisible(true);
            for (int i = 0; i < questionnaire.size(); i++) {
                if (i == nombre_hasard){
                    questions = new JLabel(questionnaire.get(i).getQuestion());
                    add(questions);
                    reponse = new JTextField();
                    reponse.setColumns(35);
                    add(reponse);
                }
            }
        }else if (actionEvent.getSource().equals(suivant)){

        }

    }
}
